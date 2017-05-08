<%--
JSP Name:     PortalSurveyDetail.jsp
Created by:   Hai Nguyen
Date Created: 08/10/10

Description:
Portal Survey Detail page to capture youth data for NYTD reporting during 
the survey period for the reporting period in the reporting fiscal year
for baseline or follow-up population.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
08/10/10  hnguyen           SMS#66384 MR-067 Initial page creation
09/01/10  hnguyen           SMS#66384 MR-067 Removed colon after survey question
09/08/10  hnguyen           SMS#66384 MR-067 Retrieve survey labels from state
09/09/10  hnguyen           SMS#66384 MR-067 Updated to set survey labels maps on jsp rather than getting from state
                            which cause a JSPException due to non-serializable maps in state
09/14/10  hnguyen           SMS#66384 MR-067 update condition to use youth current foster care outcome status
09/20/10  hnguyen           SMS#72010 Added No response for OthHlthIns-Medical
09/29/10  hnguyen           SMS#74128 Set youth current foster care status to request to resolve issue with
                            question 17-19 not saving when CM/ILC changes youth foster care status after YRD is created
                            and youth complete survey via portal.                           
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOPerson"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOReport"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PortalSurveyDetailConversation"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<%
  BaseSessionStateManager state = PortalSurveyDetailConversation.getSessionStateManager(request);

  boolean isBaseline = false;
  boolean isFollowUp = false;
  boolean indInCare = false;

  String currFTE = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME);
  String currPTE = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME);
  String empRelSkills = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME);
  String socialSecurity = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_SS_NAME);
  String eduAid = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_EDU_AID_NAME);
  String tanf = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_TANF_NAME);
  String foodStamps = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME);
  String publicHsg = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME);
  String otherIncome = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_OTH_INC_NAME);
  String highEdu = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_HECR_NAME);
  String currAttdEnr = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_CAE_NAME);
  String connectAdult = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_C2A_NAME);
  String medicaid = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_MEDICAID_NAME);
  String otherHIT = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_OHIT_NAME);
  String medical = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
  String mental = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
  String prescription = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
  String homeless = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_HOME_NAME);
  String subAbuseRef = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_SAR_NAME);
  String incarcerate = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_INC_NAME);
  String children = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_CHL_NAME);
  String marrAtBirth = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_MAB_NAME);
  String cdPopulationType = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.HDN_POPULATION_TYPE);

  //-- get attributes from state
  List errorInputs = (List) request.getAttribute(PortalSurveyDetailConversation.VALIDATION_CUSTOM_INPUTS);
  
  YouthReportDetailRetrieveSOPerson soPerson = (YouthReportDetailRetrieveSOPerson) state
                                                                                        .getAttribute(
                                                                                                      PortalSurveyDetailConversation.RETRIEVE_SO_PERSON,
                                                                                                      request);
  YouthReportDetailRetrieveSOReport soReport = (YouthReportDetailRetrieveSOReport) state
                                                                                        .getAttribute(
                                                                                                      PortalSurveyDetailConversation.RETRIEVE_SO_REPORT,
                                                                                                      request);

  Map<String, String> labelMap = new HashMap<String, String>() {
        {
          // -- fields
          put(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, PortalSurveyDetailConversation.LABEL_CURR_FTE);
          put(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, PortalSurveyDetailConversation.LABEL_CURR_PTE);
          put(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, PortalSurveyDetailConversation.LABEL_EMP_SKILLS);
          put(PortalSurveyDetailConversation.RADIO_SS_NAME, PortalSurveyDetailConversation.LABEL_SS);
          put(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, PortalSurveyDetailConversation.LABEL_EDU_AID);
          put(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, PortalSurveyDetailConversation.LABEL_OTH_INC);
          put(PortalSurveyDetailConversation.RADIO_HECR_NAME, PortalSurveyDetailConversation.LABEL_HECR);
          put(PortalSurveyDetailConversation.RADIO_CAE_NAME, PortalSurveyDetailConversation.LABEL_CAE);
          put(PortalSurveyDetailConversation.RADIO_C2A_NAME, PortalSurveyDetailConversation.LABEL_C2A);

          put(PortalSurveyDetailConversation.RADIO_HOME_NAME, PortalSurveyDetailConversation.LABEL_HOME_B);
          put(PortalSurveyDetailConversation.RADIO_SAR_NAME, PortalSurveyDetailConversation.LABEL_SAR_B);
          put(PortalSurveyDetailConversation.RADIO_INC_NAME, PortalSurveyDetailConversation.LABEL_INC_B);
          put(PortalSurveyDetailConversation.RADIO_CHL_NAME, PortalSurveyDetailConversation.LABEL_CHL_B);

          put(PortalSurveyDetailConversation.RADIO_MAB_NAME, PortalSurveyDetailConversation.LABEL_MAB);
          put(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, PortalSurveyDetailConversation.LABEL_MEDICAID);
          put(PortalSurveyDetailConversation.RADIO_OHIT_NAME, PortalSurveyDetailConversation.LABEL_OHIT);
          put(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, PortalSurveyDetailConversation.LABEL_MEDICAL);
          put(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, PortalSurveyDetailConversation.LABEL_MENTAL);
          put(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, PortalSurveyDetailConversation.LABEL_PRESCRIPTION);

          put(PortalSurveyDetailConversation.RADIO_TANF_NAME, PortalSurveyDetailConversation.LABEL_TANF);
          put(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, PortalSurveyDetailConversation.LABEL_FOOD_STMP);
          put(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, PortalSurveyDetailConversation.LABEL_PUB_HSG);
        }
      };

  Map<String, String> descMap = new HashMap<String, String>() {
        {
          // -- fields
          put(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, PortalSurveyDetailConversation.CURR_FTE_DESC);
          put(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, PortalSurveyDetailConversation.CURR_PTE_DESC);
          put(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, PortalSurveyDetailConversation.EMP_SKILLS_DESC);
          put(PortalSurveyDetailConversation.RADIO_SS_NAME, PortalSurveyDetailConversation.SS_DESC);
          put(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, PortalSurveyDetailConversation.EDU_AID_DESC);
          put(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, PortalSurveyDetailConversation.OTH_INC_DESC);
          put(PortalSurveyDetailConversation.RADIO_HECR_NAME, PortalSurveyDetailConversation.HECR_DESC);
          put(PortalSurveyDetailConversation.RADIO_CAE_NAME, PortalSurveyDetailConversation.CAE_DESC);
          put(PortalSurveyDetailConversation.RADIO_C2A_NAME, PortalSurveyDetailConversation.C2A_DESC);

          put(PortalSurveyDetailConversation.RADIO_HOME_NAME, PortalSurveyDetailConversation.HOME_DESC);
          put(PortalSurveyDetailConversation.RADIO_SAR_NAME, PortalSurveyDetailConversation.SAR_DESC);
          put(PortalSurveyDetailConversation.RADIO_INC_NAME, PortalSurveyDetailConversation.INC_DESC);
          put(PortalSurveyDetailConversation.RADIO_CHL_NAME, PortalSurveyDetailConversation.CHL_DESC);

          put(PortalSurveyDetailConversation.RADIO_MAB_NAME, PortalSurveyDetailConversation.MAB_DESC);
          put(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, PortalSurveyDetailConversation.MEDICAID_DESC);
          put(PortalSurveyDetailConversation.RADIO_OHIT_NAME, PortalSurveyDetailConversation.OHIT_DESC);
          put(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, PortalSurveyDetailConversation.MEDICAL_DESC);
          put(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, PortalSurveyDetailConversation.MENTAL_DESC);
          put(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, PortalSurveyDetailConversation.PRESCRIPTION_DESC);

          put(PortalSurveyDetailConversation.RADIO_TANF_NAME, PortalSurveyDetailConversation.TANF_DESC);
          put(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, PortalSurveyDetailConversation.FOOD_STMP_DESC);
          put(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, PortalSurveyDetailConversation.PUB_HSG_DESC);
        }
      };
    
  //Set the page mode only one mode for survey).
  String pageMode = PageModeConstants.EDIT;

  //-- soReport should never be null
  if (soReport != null) {
    indInCare = StringHelper.toBooleanSafe(soReport.getIndFcStatOutcome());
    currFTE = soReport.getCdCurrFtEmp();
    currPTE = soReport.getCdCurrPtEmp();
    empRelSkills = soReport.getCdEmpSkills();
    socialSecurity = soReport.getCdSocialSec();
    eduAid = soReport.getCdEducAid();
    otherIncome = soReport.getCdOthSupport();
    highEdu = soReport.getCdHighestEdu();
    currAttdEnr = soReport.getCdCurrEnrAtt();
    connectAdult = soReport.getCdConnAdult();
    homeless = soReport.getCdHomeless();
    subAbuseRef = soReport.getCdSubAbuseRef();
    incarcerate = soReport.getCdIncarceration();
    children = soReport.getCdChildren();
    marrAtBirth = soReport.getCdMarrAtBirth();
    medicaid = soReport.getCdMedicaid();
    otherHIT = soReport.getCdOthHlthInsTyp();
    medical = soReport.getCdMedicalSvc();
    mental = soReport.getCdMentalHlthSvc();
    prescription = soReport.getCdPrescription();
    tanf = soReport.getCdPubFinAst();
    foodStamps = soReport.getCdFoodAst();
    publicHsg = soReport.getCdHousingAst();

    cdPopulationType = soReport.getCdPopulationType();
  }

  //-- soPerson should never be null!
  if (soPerson != null) {
    // Portal Survey will display based on child current data
    indInCare = StringHelper.toBooleanSafe(soPerson.getIndFcStatOutcome());
    cdPopulationType = soPerson.getCdPopulationType();
  }

  if (PortalSurveyDetailConversation.POPULATION_TYPE_BASELINE.equals(cdPopulationType)) {
    isBaseline = true;
    labelMap.put(PortalSurveyDetailConversation.RADIO_HOME_NAME, PortalSurveyDetailConversation.LABEL_HOME_B);
    labelMap.put(PortalSurveyDetailConversation.RADIO_SAR_NAME, PortalSurveyDetailConversation.LABEL_SAR_B);
    labelMap.put(PortalSurveyDetailConversation.RADIO_INC_NAME, PortalSurveyDetailConversation.LABEL_INC_B);
    labelMap.put(PortalSurveyDetailConversation.RADIO_CHL_NAME, PortalSurveyDetailConversation.LABEL_CHL_B);
  } else if (PortalSurveyDetailConversation.POPULATION_TYPE_FOLLOW_UP.equals(cdPopulationType)) {
    isFollowUp = true;
    labelMap.put(PortalSurveyDetailConversation.RADIO_HOME_NAME, PortalSurveyDetailConversation.LABEL_HOME_F);
    labelMap.put(PortalSurveyDetailConversation.RADIO_SAR_NAME, PortalSurveyDetailConversation.LABEL_SAR_F);
    labelMap.put(PortalSurveyDetailConversation.RADIO_INC_NAME, PortalSurveyDetailConversation.LABEL_INC_F);
    labelMap.put(PortalSurveyDetailConversation.RADIO_CHL_NAME, PortalSurveyDetailConversation.LABEL_CHL_F);
  }

  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;
  int outerColspan = 4;
  String width = "5%";
  int rowspan = 2;
  int colspan = 3;
  int row = 1;

%>
<%-- Needed for Form Launch Custom tag --%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>

<%--
Create javascript functions here for page specific actions on the page. All form submits should use the
  submitValidateForm function to submit which is included in the JavaScript files included in index.jsp.
--%>
<script type="text/javascript" language="JavaScript1.2">
  window.onload = function()
  {
    onRadioChanged();
  };

  /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  };

  function onRadioChanged(){
    if(getRadioCheckedValue('<%=PortalSurveyDetailConversation.RADIO_OHIT_NAME%>') == '<%= CodesTables.CINVACAN_Y%>'){
      // Unhide question 16a
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>_lbl');
      e.style.display = '';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>_desc');
      e.style.display = '';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>_grp');
      e.style.display = '';

      if(getRadioCheckedValue('<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>') == '<%= CodesTables.CINVACAN_Y%>'){
        // Unhide question 16b
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_lbl');
	      e.style.display = '';
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_desc');
	      e.style.display = '';
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_grp');
	      e.style.display = '';
	
	      // Unhide question 16c
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_lbl');
	      e.style.display = '';
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_desc');
	      e.style.display = '';
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_grp');
	      e.style.display = '';
	    }else{
        // reset question 16b response
	      var e = document.getElementsByName('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>');
	      for( var i = 0; i < e.length; i++ ){
	        e[i].checked = false;
	      }
	      e.value = '<%= CodesTables.CINVACAN_A%>';
	
	      // reset question 16c response
	      var e = document.getElementsByName('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>');
	      for( var i = 0; i < e.length; i++ ){
	        e[i].checked = false;
	      }
	      e.value = '<%= CodesTables.CINVACAN_A%>';
	
	      // Hide question 16b
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_lbl');
	      e.style.display = 'none';
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_desc');
	      e.style.display = 'none';
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_grp');
	      e.style.display = 'none';
	
	      // Hide question 16c
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_lbl');
	      e.style.display = 'none';
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_desc');
	      e.style.display = 'none';
	      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_grp');
	      e.style.display = 'none';
	    }
    }else{
      // Reset question 16a
      var e = document.getElementsByName('<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        e[i].checked = false;
      }
      e.value = '<%= CodesTables.CINVACAN_A%>';

      // Reset question 16b
      var e = document.getElementsByName('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        e[i].checked = false;
      }
      e.value = '<%= CodesTables.CINVACAN_A%>';

      // Reset question 16c
      var e = document.getElementsByName('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        e[i].checked = false;
      }
      e.value = '<%= CodesTables.CINVACAN_A%>';

      // Hide question 16a
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>_lbl');
      e.style.display = 'none';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>_desc');
      e.style.display = 'none';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>_grp');
      e.style.display = 'none';

      // Hide question 16b
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_lbl');
      e.style.display = 'none';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_desc');
      e.style.display = 'none';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_grp');
      e.style.display = 'none';

      // Hide question 16c
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_lbl');
      e.style.display = 'none';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_desc');
      e.style.display = 'none';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_grp');
      e.style.display = 'none';
    }
    
    // Hide question 14 if question 13 response is not Yes
    if(getRadioCheckedValue('<%=PortalSurveyDetailConversation.RADIO_CHL_NAME%>') == '<%= CodesTables.CINVACAN_Y%>'){
      // Unhide question 14
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MAB_NAME%>_lbl');
      e.style.display = '';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MAB_NAME%>_desc');
      e.style.display = '';
      var e = document.getElementById('<%=PortalSurveyDetailConversation.RADIO_MAB_NAME%>_grp');
      e.style.display = '';

      var e = document.getElementsByName('<%=PortalSurveyDetailConversation.RADIO_MAB_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        e[i].disabled = false;
      }
    }else{
      // Reset question 14 response
      var e = document.getElementsByName('<%=PortalSurveyDetailConversation.RADIO_MAB_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        e[i].checked = false;
        e[i].disabled = true;
      }
      e.value = '<%= CodesTables.CINVACAN_A%>';
    }
  }
  
  function getRadioCheckedValue( radioName ){
    var oRadio = document.<%=PortalSurveyDetailConversation.FORM_NAME%>.elements[radioName];
  
    for( var i = 0; i < oRadio.length; i++){
      if(oRadio[i].checked){
        return oRadio[i].value;
      }
      
      return '';
    }
  }
</script>
<%-- Include custom tag for displaying errors on the page --%>
<impact:validateErrors />
<impact:validateForm
	name="<%=PortalSurveyDetailConversation.FORM_NAME%>"
	action="/person/PortalSurveyDetail/displaySurveyDetail"
	schema="/WEB-INF/Constraints.xsd" method="post"
	pageMode="<%=PageModeConstants.EDIT%>">
<%
  if( (isBaseline || isFollowUp) 
    && NytdHelper.isDuringSurveyPeriod(soPerson.getDtDob())){
%>
	<table width="100%" class="tableBorder" cellspacing="0" cellpadding="3"	border="0">
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(currFTE))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(currFTE))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(currFTE))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(currPTE))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(currPTE))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(currPTE))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(empRelSkills))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(empRelSkills))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(empRelSkills))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_SS_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_SS_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_SS_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_SS_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(socialSecurity))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_SS_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(socialSecurity))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_SS_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(socialSecurity))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_EDU_AID_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(eduAid))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_EDU_AID_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(eduAid))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_EDU_AID_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(eduAid))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_OTH_INC_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(otherIncome))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_OTH_INC_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(otherIncome))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_OTH_INC_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(otherIncome))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_HECR_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_HECR_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_HECR_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HECR_NAME%>"
					label="<%=PortalSurveyDetailConversation.HIGH_SCHOOL_GED%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_HS.equals(highEdu))%>"
					value="<%=CodesTables.CHIGHEDU_HS%>" tabIndex="<%=tabIndex++%>" />
                <br/>
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HECR_NAME%>"
					label="<%=PortalSurveyDetailConversation.VOC_CERTIFICATE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_VC.equals(highEdu))%>"
					value="<%=CodesTables.CHIGHEDU_VC%>" tabIndex="<%=tabIndex++%>" />
                <br/>
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HECR_NAME%>"
					label="<%=PortalSurveyDetailConversation.VOC_LICENSE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_VL.equals(highEdu))%>"
					value="<%=CodesTables.CHIGHEDU_VL%>" tabIndex="<%=tabIndex++%>" />
                <br/>
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HECR_NAME%>"
					label="<%=PortalSurveyDetailConversation.ASSOCIATE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_AD.equals(highEdu))%>"
					value="<%=CodesTables.CHIGHEDU_AD%>" tabIndex="<%=tabIndex++%>" />
                <br/>
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HECR_NAME%>"
					label="<%=PortalSurveyDetailConversation.BACHELOR%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_BD.equals(highEdu))%>"
					value="<%=CodesTables.CHIGHEDU_BD%>" tabIndex="<%=tabIndex++%>" />
                <br/>
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HECR_NAME%>"
					label="<%=PortalSurveyDetailConversation.HIGHER_DEGREE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_HD.equals(highEdu))%>"
					value="<%=CodesTables.CHIGHEDU_HD%>" tabIndex="<%=tabIndex++%>" />
                <br/>
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HECR_NAME%>"
					label="<%=PortalSurveyDetailConversation.NONE_ABOVE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_NA.equals(highEdu))%>"
					value="<%=CodesTables.CHIGHEDU_NA%>" tabIndex="<%=tabIndex++%>" />
                <br/>
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HECR_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_DC.equals(highEdu))%>"
					value="<%=CodesTables.CHIGHEDU_DC%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_CAE_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_CAE_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_CAE_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CAE_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(currAttdEnr))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CAE_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(currAttdEnr))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CAE_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(currAttdEnr))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_C2A_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_C2A_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_C2A_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_C2A_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(connectAdult))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_C2A_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(connectAdult))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_C2A_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(connectAdult))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_HOME_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_HOME_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_HOME_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HOME_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(homeless))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HOME_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(homeless))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_HOME_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(homeless))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_SAR_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_SAR_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_SAR_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_SAR_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(subAbuseRef))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_SAR_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(subAbuseRef))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_SAR_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(subAbuseRef))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_INC_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_INC_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_INC_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_INC_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(incarcerate))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_INC_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(incarcerate))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_INC_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(incarcerate))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_CHL_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_CHL_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_CHL_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CHL_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(children))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>"
					onClick="onRadioChanged()"
				/>
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CHL_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(children))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" 
          onClick="onRadioChanged()"
				/>
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_CHL_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(children))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" 
          onClick="onRadioChanged()"
				/>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>" id="<%= PortalSurveyDetailConversation.RADIO_MAB_NAME%>_lbl">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_MAB_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_MAB_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>" id="<%= PortalSurveyDetailConversation.RADIO_MAB_NAME%>_desc">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_MAB_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>" id="<%= PortalSurveyDetailConversation.RADIO_MAB_NAME%>_grp">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MAB_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(marrAtBirth))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MAB_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(marrAtBirth))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MAB_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(marrAtBirth))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MEDICAID_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(medicaid))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MEDICAID_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(medicaid))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MEDICAID_NAME%>"
					label="<%=PortalSurveyDetailConversation.DONT_KNOW%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(medicaid))%>"
					value="<%=CodesTables.CINVACAN_K%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MEDICAID_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(medicaid))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_OHIT_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_OHIT_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_OHIT_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_OHIT_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(otherHIT))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" 
					onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_OHIT_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(otherHIT))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" 
          onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_OHIT_NAME%>"
					label="<%=PortalSurveyDetailConversation.DONT_KNOW%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(otherHIT))%>"
					value="<%=CodesTables.CINVACAN_K%>" tabIndex="<%=tabIndex++%>" 
          onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_OHIT_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(otherHIT))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" 
          onClick="onRadioChanged()" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>" id="<%= PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>_lbl">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>" id="<%= PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>_desc">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>" id="<%= PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>_grp">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(medical))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>"
					onClick="onRadioChanged()" />
                <impact:validateInput type="radio"
                    name="<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>"
                    label="<%=PortalSurveyDetailConversation.NO%>"
                    checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(medical))%>"
                    value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>"
					label="<%=PortalSurveyDetailConversation.DONT_KNOW%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(medical))%>"
					value="<%=CodesTables.CINVACAN_K%>" 
					tabIndex="<%=tabIndex++%>" 
          onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MEDICAL_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(medical))%>"
					value="<%=CodesTables.CINVACAN_D%>" 
					tabIndex="<%=tabIndex++%>" 
          onClick="onRadioChanged()" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>" id="<%= PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_lbl">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>" id="<%= PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_desc">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>" id="<%= PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>_grp">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(mental))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(mental))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>"
					label="<%=PortalSurveyDetailConversation.DONT_KNOW%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(mental))%>"
					value="<%=CodesTables.CINVACAN_K%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_MENTAL_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(mental))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>" id="<%= PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_lbl">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>" id="<%= PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_desc">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>" id="<%= PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>_grp">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(prescription))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(prescription))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>"
					label="<%=PortalSurveyDetailConversation.DONT_KNOW%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(prescription))%>"
					value="<%=CodesTables.CINVACAN_K%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(prescription))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<%
		  if (isFollowUp && !indInCare ) {
		%>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_TANF_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_TANF_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_TANF_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_TANF_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(tanf))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_TANF_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(tanf))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_TANF_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(tanf))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(foodStamps))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(foodStamps))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(foodStamps))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td valign="top" colspan="<%=outerColspan%>">
				<div
					class="<%=getLabelClass(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, errorInputs)%>"><%=getLabel(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td width="<%=width%>" rowspan="<%=rowspan%>"/>
			<td valign="top" colspan="<%=colspan%>"><i><%=getDescription(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, descMap)%></i></td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">			
			<td colspan="<%=colspan%>">
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME%>"
					label="<%=PortalSurveyDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(publicHsg))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME%>"
					label="<%=PortalSurveyDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(publicHsg))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME%>"
					label="<%=PortalSurveyDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(publicHsg))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<%
		  }
		%>
	</table>
	<table width="100%" cellspacing="0" cellpadding="3" border="0">
		<tr>
			<td class="alignRight">
				<impact:ButtonTag
					name="<%=PortalSurveyDetailConversation.SAVE_BUTTON_NAME%>"
					form="<%=PortalSurveyDetailConversation.FORM_NAME%>"
					tabIndex="<%=tabIndex++%>"
					action="/person/PortalSurveyDetail/savePortalSurveyDetail"
					img="btnSave" restrictRepost="true" />
			</td>
		</tr>
	</table>
<%
  }
%>	
    <impact:validateInput type="hidden"
        name="<%= PortalSurveyDetailConversation.HDN_POPULATION_TYPE %>" value="<%=cdPopulationType%>" />
    <impact:validateInput type="hidden"
        name="<%= PortalSurveyDetailConversation.HDN_FC_STATUS %>" value="<%=StringHelper.toYorN(indInCare)%>" />
    <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>
<%!  
  String getLabelClass(String inputName, List errorInputs) {
    if (errorInputs != null && errorInputs.contains(inputName)) {
      return PortalSurveyDetailConversation.HTML_INFO_STYLE;
    } else {
      return PortalSurveyDetailConversation.HTML_LABEL_STYLE;
    }
  }

  String getLabel(String inputName, Map<String, String> labelMap) {
    return labelMap.get(inputName);
  }

  String getDescription(String inputName, Map<String, String> descMap) {
    return descMap.get(inputName);
  }%>
