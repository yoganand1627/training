<%-- 
JSP Name:     Policy Waiver
Created by:   Carina Gerry
Date Created: 8/30/2006

Description:
This JSP Displays the Policy Waiver detail.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
4/4/08		cjgerry			STGAP00007416 - fixed it so the name of the case manager 
							is the name of the person who saved the page, not the
							person who is logged in.
							
7/8/2008    Cwells         	STGAP00008188 - Fixed illegal number error by changing Integers
        					to Doubles.  This also makes the fields consistent with the Svc Auth 
        					Fields as suggested by the SME. also wrote Java script to filter the 
        					Entitlement Code dropdown by the selection made in the UAS Code dropdown.
        					 
7/14/2008    mxpatel       	STGAP00009365 - Fixed the  GenericJDBCException problem with "Sleeping Arrangement" 
							field by defining the maximum length for the field - maxLength="300" 
							 	
9/25/2008    alwilliams     STGAP00009727 - Made the following changes:
                            
                            Changed the Primary Customer and Resource fields to read only. The fields are 
                            populated when the user selects one of the entries from the Person List and 
                            Resource Results list. The Person List is displayed after clicking the Select 
                            Person PB. The Resource Results is displayed after clicking the Select Resource PB. 
                            
                            Changed the size of the Primary Customer and Resource input fields to 30. 
                            
                            Merged the Primary Customer input field and the Select Person button into the same cell. 
                            
                            Merged the Resource input field and the Resource button into the same cell.
 11/11/2008  arege          STGAP00010758 Modified code  so that the Save and Submit button is not displayed for the
                            Supervisor in approval mode.
 03/18/2011  hnguyen        SMS#97850: MR-075 Added new 30 Day Grace Period Waiver type and its reasons               
 03/21/2011  hnguyen        SMS#97850: MR-075 Corrected display of waiver types dropdown.               
                            							
        												
							
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyWaiverRetrieveSO"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.investigation.PolicyWaiverConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Hashtable"%>

<%
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
%>
<%-- Needed for Form Launch Custom tag --%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<%--
Create javascript functions here for page specific actions on the page. All form submits should use the
  submitValidateForm function to submit which is included in the JavaScript files included in index.jsp.
--%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">

 window.attachEvent('onload', updateEntCodes);

  /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  };


  //Submit the form with the correct cReqFuncCd for deleting.
  function deletePhoneRow()
  {
    bRetValue = confirm('<%=MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE")%>')
    if (bRetValue)
    {
      disableValidation("frmDetailTemplate");
    }
    else
    {
      enableValidation("frmDetailTemplate");
    }
    return bRetValue;
  }
  function openPersonList()
{
  var form = document.all["frmPolicyWaiver"];
  disableValidation("frmPolicyWaiver");
  return true;
}

 function displayWaiverDetailSection()
 {
    var policyWaiverType = document.frmPolicyWaiver.selCdWvrType.value;
    var action = '/investigation/PolicyWaiver/savePolicyWaiverType';
    document.frmPolicyWaiver.hdnWaiverType.value = policyWaiverType;
    disableValidation('frmPolicyWaiver');
    submitValidateForm( 'frmPolicyWaiver', action);
 }
 var codes252 = new Array();
codes252[0]= "|"; 
codes252[1]= "00"+"|"+"00 - Other Costs";
var codes253 = new Array();
codes253[0]= "|"; 
codes253[1]= "00"+"|"+"00 - Other Costs";
var codes450 = new Array();
codes450[0]= "|"; 
codes450[1]= "00"+"|"+"00 - Other Costs";
var codes456 = new Array();
codes456[0]= "|"; 
codes456[1]= "00"+"|"+"00 - Other Costs";
// end STGAP00002833
var codes504 = new Array();
codes504[0]= "|"; 
codes504[1]= "00"+"|"+"00 - Other Costs";
codes504[2]= "10"+"|"+"10 - Unusual Medical/Burial";
codes504[3]= "11"+"|"+"11 - Child Restraint Device";
var codes522 = new Array(); 
codes522[1]= "00"+"|"+"00 - Other Costs";
codes522[2]= "10"+"|"+"10 - Unusual Medical/Burial";
codes522[3]= "11"+"|"+"11 - Child Restraint Device"; 
codes522[4] = "99"+"|"+ "99 - Written Waiver Item";
var codes513 = new Array(); 
codes513[0]= "|"; 
codes513[1]= "12"+"|"+ "12 - Other Reimbursable Costs";
var codes511 = new Array(); 
codes511[0]= "|"; 
codes511[1]= "00"+"|"+ "00 - Other Costs";
codes511[2]= "12"+"|"+ "12 - Other Reimbursable Costs";
codes511[3]= "19"+"|"+"19 - Medical Exams (CCFA/Child)";
codes511[4]= "29"+"|"+"29 - Assessments";
codes511[5]= "54"+"|"+"54 - Psychological Evaluation";
codes511[6]= "88"+"|"+"88 - Court Appearances";
// STGAP00008445 Added 518-80 below
var codes518 = new Array(); 
codes518[0]= "|"; 
codes518[1]= "00"+"|"+ "00 - Other Costs";
codes518[2]= "12"+"|"+ "12 - Other Reimbursable Costs";
codes518[3]= "24"+"|"+ "24 - Crisis Intervention Prevent Disruption";
codes518[4]= "47"+"|"+ "47 - Crisis Intervention Behavior Management";
codes518[5]= "56"+"|"+ "56 - Transportation";
codes518[6]= "71"+"|"+ "71 - In Home Case Management";
codes518[7]= "80"+"|"+ "80 - Summer Enrichment"
codes518[8]= "88"+"|"+ "88 - Court Appearances";
codes518[9]= "95"+"|"+ "95 - In-Home Intensive Treatment";
var codes521 = new Array();
codes521[0]= "|"; 
codes521[1]= "48"+"|"+"48 - Emergency Housing";
codes521[2]= "49"+"|"+"49 - Day Care Services";
codes521[3]= "50"+"|"+"50 - Counseling";
codes521[4]= "51"+"|"+"51 - Drug Screens";
codes521[5]= "52"+"|"+"52 - Substance Abuse";
codes521[6]= "53"+"|"+"53 - Medical/Dental Services";
codes521[7]= "54"+"|"+"54 - Psychological Evaluation";
codes521[8]= "56"+"|"+"56 - Transportation";
var codes525 = new Array(); 
codes525[0]= "|"; 
codes525[1]= "19"+"|"+ "19 - Medical Exams (CCFA/Child)";
codes525[2]= "20"+"|"+ "20 - Medical Exams - Adult";
var codes531 = new Array(); 
codes531[0]= "|"; 
codes531[1]= "06"+"|"+ "06 - Support Services";
codes531[2]= "67"+"|"+ "67 - IMPACT";
codes531[3]= "68"+"|"+ "68 - Continued Parent Development";
var codes547 = new Array(); 
codes547[0]= "|"; 
codes547[1]= "96"+"|"+ "96 - Family FC Emergency Beds";
codes547[2]= "97"+"|"+ "97 - IFC Emergency Beds";
var codes551 = new Array(); 
codes551[0]= "|"; 
codes551[1]= "79"+"|"+ "79 - Prevention Services";
var codes571 = new Array(); 
codes571[0]= "|"; 
codes571[1]= "29"+"|"+ "29 - Assessments";
codes571[2]= "61"+"|"+ "61 - Homestead Services";
codes571[3]= "62"+"|"+ "62 - Crisis Intervention Payment";
var codes573 = new Array(); 
codes573[0]= "|"; 
codes573[1]= "72"+"|"+ "72 - Parent Aide Services";
var codes588 = new Array(); 
codes588[0]= "|"; 
codes588[1]= "85"+"|"+ "85 - Intensive Family Services";
codes588[2]= "86"+"|"+ "86 - Preventive Family Services";
var codes597 = new Array(); 
codes597[0]= "|"; 
codes597[1]= "W1"+"|"+ "W1 - Level1";
codes597[2]= "W2"+"|"+ "W2 - Level2";
var codes698 = new Array(); 
codes698[0]= "|"; 
codes698[1]= "41"+"|"+ "41 - Emergency Benefits";
var codes773 = new Array(); 
codes773[0]= "|"; 
codes773[1]= "73"+"|"+ "73 - Family Preservation - Placement Prevention";
codes773[2]= "24"+"|"+ "24 - Crisis Intervention Prevent Disruption";
var codes774 = new Array(); 
codes774[0]= "|"; 
codes774[1]= "74"+"|"+ "74 - Diversion and Family Support Services";
codes774[2]= "C9"+"|"+ "C9 - CPPC Expenses";
var codes783 = new Array(); 
codes783[0]= "|"; 
codes783[1]= "83"+"|"+ "83 - Intervention and Support Services";
var codes784 = new Array(); 
codes784[0]= "|"; 
codes784[1]= "84"+"|"+ "84 - Adoption Promotion Activities";
codes784[2]= "57"+"|"+ "57 - Pre and Post Adoption and Support Services";
var codes873 = new Array(); 
codes873[0]= "|"; 
codes873[1]= "24"+"|"+ "24 - Crisis Intervention Prevent Disruption";
codes873[2]= "R1"+"|"+ "R1 - Residential After-Care Services";
codes873[3]= "R2"+"|"+ "R2 - Comprehensive Discharge Planning";
codes873[4]= "R3"+"|"+ "R3 - Placement Services";
codes873[5]= "R4"+"|"+ "R4 - Intensive Case Management";
codes873[6]= "R5"+"|"+ "R5 - Therapeutic Counseling";
codes873[7]= "R6"+"|"+ "R6 - Behavior Management";
codes873[8]= "R7"+"|"+ "R7 - 24-hour Crisis Intervention";
codes873[9]= "S7"+"|"+ "S7 - Relative Caregiver Support Services";
var codes874 = new Array(); 
codes874[0]= "|"; 
codes874[1]= "S5"+"|"+ "S5 - Parent Support Services Early Intervention";
codes874[2]= "S6"+"|"+ "S6 - Parent Support Services Placement Prevention";
codes874[3]= "S7"+"|"+ "S7 - Relative Caregiver Support Services ";
codes874[4]= "S8"+"|"+ "S8 - Substance Abuse Treatment and Support Services";
codes874[5]= "S9"+"|"+ "S9 - Healthy Marriage and Co-Parenting Support Services";
var codes883 = new Array(); 
codes883[0]= "|"; 
codes883[1]= "83"+"|"+ "83 - Intervention and Support Services";
codes883[2]= "S3"+"|"+ "S3 - Family Access and Visitation Center Visits";
codes883[3]= "S4"+"|"+ "S4 - Transitional Support Services";
var codes884 = new Array(); 
codes884[0]= "|"; 
codes884[1]= "84"+"|"+ "84 - Adoption Promotion Activities";
codes884[2]= "S1"+"|"+ "S1 - Foster Care Transitional Support Services";
codes884[3]= "S2"+"|"+ "S2 - Foster Care Emancipation Support Services";
var codes510 = new Array(); 
codes510[0]= "|"; 
codes510[1]= "33"+"|"+ "33 - Non Recurring Adoption Expenses";
var codes512 = new Array(); 
codes512[0]= "|"; 
codes512[1]= "17"+"|"+ "17 - Supplemental Supervision";
codes512[2]= "57"+"|"+ "57 - Pre and Post Adoption and Support Services";
codes512[3]= "58"+"|"+ "58 - Special Services Adoption Assistance - Surgery, Therapy, Etc.";
codes512[4]= "60"+"|"+ "60 - Special Services Adoption Assistance  Respite Care";
codes512[5]= "77"+"|"+ "77 - Adoptive Placement Reimbursement Foster Parent Conversion";
var codes582 = new Array(); 
codes582[0]= "|"; 
codes582[1]= "28"+"|"+ "28 - Financial Literacy Training";
codes582[2]= "32"+"|"+ "32 - Independent Living Meetings";
codes582[3]= "42"+"|"+ "42 - Self Evaluation Meetings";
codes582[4]= "44"+"|"+ "44 - Diarist Payment";
codes582[5]= "87"+"|"+ "87 - Survey Stipend";
codes582[6]= "89"+"|"+ "89 - Half day Event";
codes582[7]= "93"+"|"+ "93 - Full day Event";
var codes583 = new Array(); 
codes583[0]= "|"; 
codes583[1]= "75"+"|"+ "75 - College Related Expenses";
var codes585 = new Array(); 
codes585[0]= "|"; 
codes585[1]= "76"+"|"+ "76 - Educational and Enrichment Expenses";
codes585[2]= "80"+"|"+ "80 - Summer Enrichment";
var codes586 = new Array(); 
codes586[0]= "|"; 
codes586[1]= "29"+"|"+ "29 - Assessments";
codes586[2]= "78"+"|"+ "78 - Transitional Living Related Expenses";
var codes584 = new Array(); 
codes584 = codes583;
var codes591 = new Array(); 
codes591 = codes583;
var codes576 = new Array();
codes576=codes522;
var codes578 = new Array();
codes578=codes522;
var codes598 = new Array();
codes598 = codes597;

/// These arrays are used to populate the service codes



<impact:codeArray codeName="<%= CodesTables.CSVCCODE %>" arrayName="<%= CodesTables.CSVCCODE %>" blankValue="true" orderBy="decode"/> 
<impact:codeArray codeName="CENTCODE" arrayName="entCodes" blankValue="true" orderBy="decode"/>
function updateEntCodes()
{
var category = frmPolicyWaiver.cdWvrUasCd.value;
var service = frmPolicyWaiver.cdWvrEntCd.value;
var options = frmPolicyWaiver.cdWvrEntCd.options;
if(category==""){
//New mode so do not need to filter the entitlement codes dropdown
populateDropdown( frmPolicyWaiver.cdWvrEntCd , "", entCodes );
}else{
var codeArray = eval("codes" + category);
// This condition is added to skip the call to populate drop down 
if(options==null){
// Field is disabled so no need to call the populate drop down
                 }else{
populateDropdown( frmPolicyWaiver.cdWvrEntCd , "", codeArray );
 					  }
document.frmPolicyWaiver.cdWvrEntCd.value=service;
    }
    updateServiceDescription();
}

// STGAP00008188 This Method takes the UAS Code and creates a filter for 
// Service Description Based on the UAS code only.  
function updateServiceDescription() 
{
var category = frmPolicyWaiver.cdWvrUasCd.value;
var service = frmPolicyWaiver.cdWvrEntCd.value;
var options = frmPolicyWaiver.cdWvrEntCd.options;
var codeArray = <%= CodesTables.CSVCCODE %>;
var categoryCodeArray = new Array();
var j = 1;
if(category == null){
clearDropdown(frmPolicyWaiver.cdWvrSvcDesc);
}
else{
if(service == null || service == ""){

categoryCodeArray[0] = "|";

for (var q=0; q < codeArray.length; q++)
     {

      var code = codeArray[q].substring(0,codeArray[q].indexOf("|"));
      var decode = codeArray[q].substring( codeArray[q].indexOf("|")+1, codeArray[q].length);
      var categoryCode = category.substring(0,3);
      var codeSubString = code.substring(0,3);
      
      if(codeSubString == categoryCode){
      categoryCodeArray[j] = code + "|" + decode;
      j++; 
     }
}
 populateDropdown(frmPolicyWaiver.cdWvrSvcDesc, "", categoryCodeArray);
}
else{
updateServiceDescriptionFull();
			}
		}
	}

//STGAP00008188  Function is used to filter service description with information 
// from UAS code and Entiltement code. 
function updateServiceDescriptionFull(){
var category = frmPolicyWaiver.cdWvrUasCd.value;
var description = frmPolicyWaiver.cdWvrSvcDesc.value;
var service = frmPolicyWaiver.cdWvrEntCd.value;
var fullCode = category + service;
var codeArray2 = <%= CodesTables.CSVCCODE %>;
var categoryCodeArray = new Array();
categoryCodeArray[0] = "|";
var j = 1;
if(service !=null && service != "")
{ 
  clearDropdown(frmPolicyWaiver.cdWvrSvcDesc);
for (var q=0; q < codeArray2.length; q++)
     {
      var decode = codeArray2[q].substring( codeArray2[q].indexOf("|")+1, codeArray2[q].length);
     var code = codeArray2[q].substring(0,codeArray2[q].indexOf("|"));
      var categoryCode = code.substring(0,5);
      if(fullCode == categoryCode){
      categoryCodeArray[j] = code + "|" + decode;
      j++;
      	}
      
     }
populateDropdown(frmPolicyWaiver.cdWvrSvcDesc, "", categoryCodeArray);
document.frmPolicyWaiver.cdWvrSvcDesc.value=description;
}
else if(category != null)
{
updateServiceDescription();
}
}
 
 
</script>
<impact:validateErrors />
<%-- Start the form - See the Form Validation Cookbook or Custom Tag list for details
       on the attributes of the validateForm tag --%>
<impact:validateForm name="frmPolicyWaiver" method="post"
	action="/investigation/PolicyWaiver/savePolicyWaiver"
	pageMode="<%=pageMode%>"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.PolicyWaiverCustomValidation"
	schema="/WEB-INF/Constraints.xsd">
	<%-- Include any hidden fields needed on the page
       Hidden fields are used for variables passed into the page as request parameters
       AND for hidden fields that need to be used for saving or deleting the detail on this page. --%>
	<input type="hidden" name="hdnWaiverType"
		value="<%=waiverTypeSelected%>" />
	<impact:validateInput type="hidden" name="cReqFuncCd"
		value="<%=szCReqFuncCd%>" />
	<impact:validateInput type="hidden" name="tsLastUpdate"
		value="<%=tsLastUpdate%>" />
	<impact:validateInput type="hidden" name="pwTsLastUpdate"
		value="<%=pwTsLastUpdate%>" />
	<%-- Start the HTML for the page --%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<%
			  if (approvalStatus) {
			%>
			<td>
				<impact:ButtonTag name="btnApprovalStatus"
					tabIndex="<%=tabIndex++%>" img="btnApprovalStatus"
					form="frmPolicyWaiver"
					action="/workload/ApprovalStatus/displayStatus" />
			</td>
			<%
			  }
			%>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="5">
				Policy Waiver Type
			</th>
		</tr>
		<tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="displayOnlyInput" colspan="3"
					label="Case Manager" value="<%=caseManager%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dtDtWvrRequest" colspan="1"
					label="Request Date" value="<%=dateOfRequest%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="tmWvrRequest" colspan="1"
					label="Time" value="<%=timeOfRequest%>" />
			</td>
		</tr>
		<%
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
		%>
		<tr>
			<td>
				<impact:validateSelect label="Waiver Type" name="selCdWvrType"
					tabIndex="<%=tabIndex++%>"
					excludeOptions="<%=excludeList.values()%>"
					disabled="<%=String.valueOf(sDisableWvrTypeOnly)%>"
					codesTable="CWVRTYP" required="true" value="<%=waiverType%>" />
			</td>
		</tr>
	</table>
	<%
	  if (pageMode.equals(PageModeConstants.NEW)) {
	%>
	<table cellspacing="0" cellPadding="3" width="100%" border="0">
		<tr>
			<td class="alignLeft" width="85%">
				&nbsp;
			</td>
			<td class="alignRight">
				<impact:ButtonTag name="btnContinue" img="btnContinue" align="right"
					form="frmPolicyWaiver"
					action="/investigation/PolicyWaiver/savePolicyWaiverType"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<%
	  }
	%>

	<%
	  if (sDisplayButtons) {
	%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="5">
				Policy Waiver Detail
			</th>
		</tr>

		<%
		  if ((CodesTables.CWVRTYP_WIV).equals(waiverType) || (CodesTables.CWVRTYP_WCL).equals(waiverType)) {
		%>
		<tr>
			<%
			  if ((CodesTables.CWVRTYP_WIV).equals(waiverType)) {
			%>
			<td>
				<impact:validateSelect label="Reason" name="selCdWvrReason"
					tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(sDisableField)%>" codesTable="CWVRRSN"
					required="true" value="<%=waiverReason%>" />
			</td>
			<%
			  } else {
			%>
			<td>
				<impact:validateSelect label="Reason" name="selCdWvrReason"
					tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(sDisableField)%>" codesTable="CWCLRSN"
					required="false" value="<%=waiverReason%>" />
			</td>

			<%
			  }
			%>
		</tr>

		<tr>
			<td>
				<impact:validateDate name="dtDtWvrExprtn" disabled="false"
					label="Expiration Date"
					disabled="<%=String.valueOf(sDisableField)%>"
					value="<%=dateOfExpiration%>" size="8" constraint="Date"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>

		<tr>
			<td valign="top">
				<impact:validateTextArea name="txtSzTxtWvrComments" colspan="5"
					label="Comments" rows="4" cols="80" conditionallyRequired="true"
					tabIndex="<%=tabIndex++%>" constraint="Comments"
					disabled="<%=String.valueOf(sDisableField)%>"><%=comments%>
				</impact:validateTextArea>
			</td>
		</tr>
		<%
		  } else if ((CodesTables.CWVRTYP_WCS).equals(waiverType)) {
		%>
		<tr>
			<td>
				<impact:validateSelect label="Contact Month" name="mnthWvrCtct"
					tabIndex="<%=tabIndex++%>" codesTable="CMONTHS"
					value="<%=monthOfContact%>" required="true"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
			<td>
				<impact:validateSelect label="Contact Year" name="yrWvrCtct"
					tabIndex="<%=tabIndex++%>" codesTable="CYEAR"
					value="<%=yearOfContact%>" required="true"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="personByIdWvrPrnUnableCnct"
					label="Person Unable to Contact" conditionallyRequired="true"
					value="<%=personByIdWvrPrnUnableCnct%>" />
			</td>
			<input type="hidden" name="personIdForPullback"
				value="<%=personIdForPullback%>" />
			<td>
				<%
				  if (!sDisableField) {
				%>
				<impact:ButtonTag name="btnSelectPerson" accessKey="P"
					backSafe="true" tabIndex='<%=tabIndex++%>'
					action="/investigation/PolicyWaiver/retrievePerson"
					form="frmPolicyWaiver"
					function="disableValidation('frmPolicyWaiver');"
					img="btnSelectPerson" editableMode='<%=EditableMode.EDIT%>' />
				<%
				  }
				%>
			</td>
			<td>
				&nbsp;
			</td>
		</tr>

		<td width="20%">
			<impact:validateInput tabIndex="<%=tabIndex++%>" value="<%=other%>"
				type="text" name="txtWvrOther" label="Other"
				conditionallyRequired="true" cssClass="formInput" size="15"
				maxLength="30" constraint="Paragraph"
				disabled="<%=String.valueOf(sDisableField)%>" />
		</td>

		<tr>
			<td>
				<impact:validateSelect label="Reason" name="selCdWvrReason"
					tabIndex="<%=tabIndex++%>" codesTable="CWCSRSN" required="true"
					value="<%=waiverReason%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<span class="formRequiredText">*</span>Comments:Note all attempted
				contact dates and methods
			</td>
		</tr>

		<tr>
			<td colspan="4" valign="top">
				<impact:validateTextArea name="txtSzTxtWvrComments" colspan="5"
					label="" rows="4" cols="80" conditionallyRequired="false"
					tabIndex="<%=tabIndex++%>" constraint="Comments"
					disabled="<%=String.valueOf(sDisableField)%>"><%=comments%>
				</impact:validateTextArea>
			</td>
		</tr>
		<%
		  } else if ((CodesTables.CWVRTYP_WPW).equals(waiverType)) {
		%>
		<tr>
			<td>
				<impact:validateSelect label="Reason" name="selCdWvrReason"
					tabIndex="<%=tabIndex++%>" codesTable="CWPWRSN" required="true"
					value="<%=waiverReason%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateSelect label="Justification"
					name="cdWvrJustification" tabIndex="<%=tabIndex++%>"
					codesTable="CWPWJTF" required="true"
					value="<%=waiverJustification%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate name="dtWvrBegin" disabled="false"
					label="Begin Date" value="<%=dateOfBegin%>" size="8"
					constraint="Date" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>

			<td>
				<impact:validateDate name="dtWvrEnd" disabled="false"
					label="End Date" value="<%=dateOfEnd%>" size="8" constraint="Date"
					tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>

		<tr>
			<td width="20%">
				<impact:validateInput tabIndex="<%=tabIndex++%>"
					value="<%=waiverCapacity%>" type="text" name="txtWvrCapacity"
					label="Waiver Capacity" conditionallyRequired="false"
					cssClass="formInput" size="2" maxLength="2" constraint="Numeric"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td valign="top">
				<impact:validateTextArea name="txtSlpArngmts" colspan="5"
					label="Sleeping Arrangements" rows="4" cols="80" maxLength="300"
					conditionallyRequired="true" tabIndex="<%=tabIndex++%>"
					constraint="Paragraph"
					disabled="<%=String.valueOf(sDisableField)%>"><%=sleepingArrangements%>

				</impact:validateTextArea>
			</td>
		</tr>

		<tr>
			<td valign="top">
				<impact:validateTextArea name="txtSzTxtWvrComments" colspan="5"
					label="Comments" rows="4" cols="80" conditionallyRequired="true"
					tabIndex="<%=tabIndex++%>" constraint="Comments"
					disabled="<%=String.valueOf(sDisableField)%>"><%=comments%>
				</impact:validateTextArea>
			</td>
		</tr>
		<%
		  } else if ((CodesTables.CWVRTYP_WLC).equals(waiverType)) {
		%>
		<tr>
			<td>
				<impact:validateSelect label="Reason" name="selCdWvrReason"
					tabIndex="<%=tabIndex++%>" codesTable="CWLCRSN" required="true"
					value="<%=waiverReason%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateSelect label="Justification"
					name="cdWvrJustification" tabIndex="<%=tabIndex++%>"
					codesTable="CWLCJTF" required="true"
					value="<%=waiverJustification%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate name="dtWvrBegin" disabled="false"
					label="Begin Date" value="<%=dateOfBegin%>" size="8"
					constraint="Date" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>

			<td>
				<impact:validateDate name="dtWvrEnd" disabled="false"
					label="End Date" value="<%=dateOfEnd%>" size="8" constraint="Date"
					tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>

		<tr>
			<td width="20%">
				<impact:validateInput tabIndex="<%=tabIndex++%>"
					value="<%=approvedPerDiem%>" type="text" name="amtAppPrdm"
					label="Approved Per Diem" conditionallyRequired="true"
					cssClass="formInput" size="15" maxLength="30"
					constraint="Paragraph"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td valign="top">
				<impact:validateTextArea name="txtSzTxtWvrComments" colspan="5"
					label="Comments" rows="4" cols="80" conditionallyRequired="true"
					tabIndex="<%=tabIndex++%>" constraint="Comments"
					disabled="<%=String.valueOf(sDisableField)%>"><%=comments%>
				</impact:validateTextArea>
			</td>
		</tr>
		<%
		  } else if ((CodesTables.CWVRTYP_WAS).equals(waiverType)) {
		%>
		<tr>
			<td>
				<impact:validateSelect label="County" name="cdWvrAuthCounty"
					tabIndex="<%=tabIndex++%>" codesTable="CCOUNT" required="true"
					value="<%=county%>" disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
			<td>
				<impact:validateSelect label="County of payment"
					name="cdWvrPmtCounty" tabIndex="<%=tabIndex++%>"
					codesTable="CCOUNT" required="true" value="<%=ctyOfPmt%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateSelect label="UAS Code" name="cdWvrUasCd"
					onChange="updateEntCodes();" tabIndex="<%=tabIndex++%>"
					codesTable="CPRGCOD1" required="true" value="<%=UASCode%>"
					disabled="<%=String.valueOf(sDisableField)%>" style="WIDTH:220px" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateSelect label="Entitlement Code" name="cdWvrEntCd"
					tabIndex="<%=tabIndex++%>" codesTable="CENTCODE" required="false"
					value="<%=etntCode%>" onChange="updateServiceDescriptionFull()" disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate name="dtWvrBegin" disabled="false"
					label="Begin Date" value="<%=dateOfBegin%>" size="8"
					constraint="Date" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>

			<td>
				<impact:validateDate name="dtWvrEnd" disabled="false"
					label="End Date" value="<%=dateOfEnd%>" size="8" constraint="Date"
					tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
		</tr>

		<tr>
			<input type="hidden" name="personIdForPullback"
				value="<%=personIdForPullback%>" />
			<!-- td width="20%" -->
			<td>
				<impact:validateInput tabIndex='<%=tabIndex%>' type="text"
					name="personByIdWvrPryCust" label="Primary Customer"
					conditionallyRequired="false" cssClass="formInput" 
					value="<%=personByIdWvrPryCust%>" 
					size="30" maxLength="30" constraint="Paragraph"
					disabled="<%=String.valueOf(sDisableField)%>" 
					readOnly="true" />
				<%
				  if (!sDisableField) {
				%>
				<impact:ButtonTag name="btnSelectPerson" accessKey="P"
					backSafe="true" tabIndex='<%=tabIndex++%>'
					action="/investigation/PolicyWaiver/retrievePerson"
					form="frmPolicyWaiver"
					function="disableValidation('frmPolicyWaiver');"
					img="btnSelectPerson" editableMode='<%=EditableMode.EDIT%>' />
				<%
				  }
				%>
			</td>
			<td>
				&nbsp;
			</td>

		</tr>
		<tr>
			<!- td width="20%" -->
			<td>
				<impact:validateInput tabIndex='<%=tabIndex%>' type="text"
					name="capsResource" label="Resource" conditionallyRequired="false"
					cssClass="formInput" value="<%=capsResource%>"
					size="30" maxLength="30" constraint="Paragraph"
					disabled="<%=String.valueOf(sDisableField)%>" 
					readOnly="true" />
				<%
				  if (!sDisableField) {
				%>
				<impact:ButtonTag name="btnSelectResource" accessKey="P"
					backSafe="true" img="btnSelectResource" tabIndex="<%=tabIndex++%>"
					function="disableValidation('frmPolicyWaiver');"
					form="frmPolicyWaiver"
					action="/investigation/PolicyWaiver/retrieveResource"
					editableMode='<%=EditableMode.EDIT%>' />
				<%
				  }
				%>
				<input type="hidden" name="resourceIdForPullback"
					value="<%=resourceIdForPullback%>" />
			</td>
		</tr>

		<tr>
			<td>
				<impact:validateSelect label="Service Description"
					name="cdWvrSvcDesc" tabIndex="<%=tabIndex++%>"
					codesTable="CSVCCODE" required="false" value="<%=svcDesc%>"
					disabled="<%=String.valueOf(sDisableField)%>" style="WIDTH:400px" />
			</td>
		</tr>

		<tr>
			<td width="20%">
				<impact:validateInput tabIndex="<%=tabIndex++%>"
					value="<%=FormattingHelper.formatDouble(policyWaiverRetrieveSO.getAmtWvr(), 2)%>"
					type="text" name="amtWvr" label="Amount"
					conditionallyRequired="true" cssClass="formInput" size="15"
					maxLength="30" constraint="DoubleToHundredths"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>
			<td width="20%">
				<impact:validateInput tabIndex="<%=tabIndex++%>"
					value="<%=FormattingHelper.formatDouble(policyWaiverRetrieveSO.getNbrWvrUnit(), 2)%>"
					type="text" name="nbrWvrUnit" label="Units"
					conditionallyRequired="true" cssClass="formInput" size="15"
					maxLength="30" constraint="DoubleToHundredths"
					disabled="<%=String.valueOf(sDisableField)%>" />
			</td>

		</tr>

		<tr>
			<td valign="top">
				<impact:validateTextArea name="txtSzTxtWvrComments" colspan="5"
					label="Comments" rows="4" cols="80" conditionallyRequired="true"
					tabIndex="<%=tabIndex++%>" constraint="Comments"
					disabled="<%=String.valueOf(sDisableField)%>"><%=comments%>
				</impact:validateTextArea>
			</td>
		</tr>
        <%
          } else if ((CodesTables.CWVRTYP_WGP).equals(waiverType)) {
        %>
        <tr>
            <td>
                <impact:validateSelect label="Reason" name="selCdWvrReason"
                    tabIndex="<%=tabIndex++%>" codesTable="CWGPRSN" required="true"
                    value="<%=waiverReason%>"
                    disabled="<%=String.valueOf(sDisableField)%>" />
            </td>
        </tr>
        <tr>
            <td><label name="label_dtWvrBegin" id="label_dtWvrBegin_Id" class="formLabel" value="Begin Date">Begin Date:</label></td>
            <td><impact:validateDisplayOnlyField name="dtWvrBegin" colspan="1" value="<%=dateOfBegin%>" />
            <!-- <input type="text" name="dtWvrBegin" id="dtWvrBegin_Id" maxlength="10" size="8" title="Begin Date" value="<%=dateOfBegin%>" disabled/> --></td>
            <td><label name="label_dtWvrEnd" id="label_dtWvrEnd_Id" class="formLabel" value="End Date">End Date:</label></td>
            <td><impact:validateDisplayOnlyField name="dtWvrEnd" colspan="1" value="<%=dateOfEnd%>" />
            <!-- <input type="text" name="dtWvrEnd" id="dtWvrEnd_Id" maxlength="10" size="8" title="End Date" value="<%=dateOfEnd%>" disabled/> --></td>
        </tr>
        <tr>
            <td valign="top">
                <impact:validateTextArea name="txtSzTxtWvrComments" colspan="5"
                    label="Comments" rows="4" cols="80" conditionallyRequired="true"
                    tabIndex="<%=tabIndex++%>" constraint="Comments"
                    disabled="<%=String.valueOf(sDisableField)%>"><%=comments%>
                </impact:validateTextArea>
            </td>
        </tr>
		<%
		  }
		%>
	</table>
	<%-- End Detail --%>
	<table cellspacing="0" cellPadding="3" width="100%" border="0">
		<tr>
			<%
			  if (bShowDeleteButton) {
			%>
			<td class="alignLeft" width="85%">
				<impact:ButtonTag name="btnDelete" img="btnDelete" align="right"
					form="frmPolicyWaiver"
					action="/investigation/PolicyWaiver/deletePolicyWaiver"
					align="left" tabIndex="<%=tabIndex++%>" />
			</td>
			<%
			  } else {
			%>
			<td class="alignLeft" width="85%">
				&nbsp;
			</td>
			<%
			  }
			%>
			<% 
			if(bShowSaveAndSubmitButton){
			%>
			<td class="alignRight">
				<%--
        Button Tag:
        o Always pass a tabIndex and the img attribute as well as a unique name
        o Always pass form="yourFORMNAME" and action="/servlet/conversation/command"
        o If you are submitting an impact:validateForm set validate="true" (almost all cases)
        o If you need to call a custom function see the delete button example
        o If you want your button to align right pass align="right" (left is default)
        o If you want want the "Are you sure you want to navigate away from this page..." pop-up to appear
        o Set navAwayCk to true (accepts boolean or "true").
        --%>
				<impact:ButtonTag name="btnSaveAndSubmit" img="btnSaveAndSubmit"
					align="right" form="frmPolicyWaiver"
					action="/investigation/PolicyWaiver/saveAndSubmitPolicyWaiver"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<%
			}
			 %>
			<td class="alignRight">
				<impact:ButtonTag name="btnSave" img="btnSave" align="right"
					form="frmPolicyWaiver"
					action="/investigation/PolicyWaiver/savePolicyWaiver"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<%
	  }
	%>



	<%--  Always include this hidden field in your form --%>
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<%-- Close Validate Form Custom Tag --%>
</impact:validateForm>
<br />