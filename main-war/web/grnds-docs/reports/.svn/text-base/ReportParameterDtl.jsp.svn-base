<%--
JSP Name:     ReportParameterDtl.jsp
Created by:   Ronnie Phelps
Date Created: 11/15/07

Description:
This JSP allows the user to enter parameters to launch the report

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
11/15/07  Ronnie Phelps     Initial jsp creation
11/21/07  Stephen Roberts   Added while loop that dynamically creates the HTML input elements
                            using custom tags.
11/12/08  Van Vo            Default county and region with user's county and region except for region 99 and county XXX   
							These are cross-county users and usually generate regional or statewide reports or reports for 
							county at choice.  
02/19/09  Van Vo            Added hint text on how to run statewide report.	
04/02/09  Van Vo      		MR-026 STGAP00013184: adding new parameter Denial Reason as dropdown for TCM Denied Claims report                        
04/16/09  Van Vo            STGAP00013329: added UAS codes tables parameter for Invoice report; added conditionally required fields
               				STGAP00013351: added 2 new Month/Year parameter name, applied to reports that have 2+ Month/Year parameters
               				so constraint validation can differentiate between the fields and display individual label name in error message. 	
05/05/09  Van Vo            STGAP00013607: update to STGAP00013329 - use textbox for UAS program code instead of dropdown; added 2 new
                            parameters invoice type and phase.    
02/12/10  Van Vo            MR-34 and MR-59 - PPA report (SMS45483): new parameter drop down with filter.
02/25/10  Van Vo			SMS46406/8: Added exclude option based on report sqr filename to display dynamic list of home and facility types for Resource reports.
03/09/10  Van Vo            SMS46614, 46493: added custom option list for Provider List report. Made Facility List exclude option list (include) option list because 
                            these reports look for specific types.	
05/05/10  Van Vo            SMS#51990: Add Home List's parameters 
                                       Consolidate code that populates and displays dropdown value list since the number of drop down list parameter increases
                                       and multiple resource reports use different sublists of the same code type. 
                            SMS#52949: fixed dropdown parameters losing filter when page fails constraint validation and repaints  
09/21/10  schoi             SMS #54117: Added a condition for Diversion Activity dropdown to have the options for open/closed/all cases
01/03/10  T Bailey          SMS# 74618: Special Inv Report - Modify Special Inv type from text box to a drop down parameter
01/03/10  T Bailey			SMS# 78537: Cases W/O FTM - Add drop down parameter box with filter for Ongoing and Foster Care Cases Only           	        
03/02/11  T Bailey			SMS# 94000: Education Detail - Add drop down parameter box with filter for Ongoing and Foster Care Cases Only           	        
03/02/11  T Bailey			SMS# 94002: FTM W/O Parent Participation - Add drop down parameter box with filter for Ongoing and Foster Care Cases Only           	        
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.String"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportParametersSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.reports.ReportStaffSearchDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>


<%
 UserProfile user = UserProfileHelper.getUserProfile(request);
 // SMS-52949: Populate report static info when page failed constraint validation too. The hdn fiels are used to populate the option lists.
 String hdnNmRptSqrName = request.getParameter("hdnNmRptSqrName") == null ? request.getParameter("szNmRptSqrName") : request.getParameter("hdnNmRptSqrName");	
 String hdnNmRptSqrVer = request.getParameter("hdnNmRptSqrVer") == null ? request.getParameter("szNmRptSqrVer") : request.getParameter("hdnNmRptSqrVer");
 String hdnNmRptType = request.getParameter("hdnNmRptType") == null ? request.getParameter("szNmRptType") : request.getParameter("hdnNmRptType");
 BaseSessionStateManager state = (BaseSessionStateManager)
  request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

 //Set the page mode
 String pageMode = PageModeConstants.EDIT;

 int tabIndex = 1;
 String reportName = (String)state.getAttribute("NAME_OF_REPORT", request);
 List<RetrieveReportParametersSO> list = (List)state.getAttribute("PARAMETER_LIST", request);
 Iterator<RetrieveReportParametersSO>  parmIterator = list.iterator(); 
 boolean hasStaffName= false;
 ReportStaffSearchDB reportStaffSearchDb = (ReportStaffSearchDB)
         state.getAttribute(ReportsConversation.REPORT_STAFF_SEARCH_DB, request);
 hasStaffName = (reportStaffSearchDb != null && reportStaffSearchDb.getStaffId()!=0);
 
 String staffIdString = (hasStaffName) ? Integer.toString(reportStaffSearchDb.getStaffId()):"" ;    
 // STGAP00011011 - default county and region with user's county and region; 
 // set blank if user is of region 99 and/or county XXX   
 UserProfile userProfile = UserProfileHelper.getUserProfile(request);
 String userCounty = userProfile.getUserCounty();
 String userRegion = userProfile.getUserRegion();
 if (userCounty == null || "XXX".equalsIgnoreCase(userCounty) ) {
  userCounty = "";
 }
 // fail-safe since most reports set max length for county code at 3 chars
 if (userCounty.length() > 3) {
   userCounty = "";
  }
 if (userRegion == null || "099".equalsIgnoreCase(userRegion) ) {
  userRegion = "";
 } else {
 // user region was retrieved from Unit table which has 3-byte region code (eg 017 for Region 17); 
 // region dropdown sends 2-byte region code (17 for Region 17) to reports so remove the first byte, 
 // which should always be 0
  if (userRegion.trim().length() == 3) {
   userRegion = userRegion.substring(1);
  }
  // fail-safe when region code retrieved is not at length of 2 or 3
  // also most reports set max length for region code at 2 chars
  if (userRegion.length() > 2) {
   userRegion = "";
  }
 }
 // STGAP00012549 - adding hint on how to run statewide view of a report
 boolean hasRegionParm = false;
 boolean hasCountyParam = false;
 boolean regionRequired = false;
 boolean countyRequired = false;
 boolean hasOptionalRegionCountyParm = false;
 boolean hasOptionalRegionOnly = false;
 String statewideMessage = "";
 String udrMessage = "";
 
 // SMS #54117 Diversion Activity Report is having 'N' parameter for 'Open' Cases, 
 // 'Y' for 'Closed' Cases and blank string for 'All' Cases
 String blankValueDefault = "";
 String cdAllCases = "All";
 String cdOpenCases = "Open";
 String cdClosedCases = "Closed";
 
 Iterator<RetrieveReportParametersSO>  parmItr = list.iterator(); 
 while (parmItr.hasNext())
    {
      RetrieveReportParametersSO parmSO = parmItr.next();
      if (("COUNTYCD".equals(parmSO.getNmRptParmName()))) {
        hasCountyParam = true;
        if ("Y".equals(parmSO.getIndRequired())) {
          countyRequired =  true;
        }
      }
      if (("REGIONCD".equals(parmSO.getNmRptParmName()))) {
        hasRegionParm = true;
        if ("Y".equals(parmSO.getIndRequired())) {
          regionRequired =  true;
        }
      }
    }  
 if (hasRegionParm && !regionRequired && hasCountyParam && !countyRequired) {
   hasOptionalRegionCountyParm = true;
   statewideMessage = "Tip:  Set both region and county paramaters blank to generate the statewide or non-region/county specific view of this report.";
 } else if (hasRegionParm && !regionRequired && (!hasCountyParam || (hasCountyParam && countyRequired))) {
     hasOptionalRegionOnly = true;
     statewideMessage = "Tip:  Set the region parameter blank to generate the statewide or non-county specific view of this report.";
 }
 // end STGAP00012549  
 // SMS45483 - PPA report to exclude regular invoice (non adjustment invoice)
 List excludeINVADJCD = new ArrayList();
 excludeINVADJCD.add(CodesTables.CINVADJT_N);
 
  // SMS#51990: Set option list depend on resource report. 
 List<Option> facilOptionList = new ArrayList<Option>();
 List<Option> resourceOptionList = new ArrayList<Option>();
 List<Option> catOptionList = new ArrayList<Option>();
 List<Option> statusOptionList = new ArrayList<Option>();
 List<Option> caseStatusOptionList = new ArrayList<Option>();
 List<Option> stageOptionList = new ArrayList<Option>();
 

 if (ReportsConversation.RELATIVE_RESOURCE_RPRT_SQR_NAME.equals(hdnNmRptSqrName) || ReportsConversation.NON_PLACEMENT_RELATIVE_RESOURCE_RPRT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_NA, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_NA)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_NR, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_NR)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_RC, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_RC)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_RE, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_RE)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_RN, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_RN)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_RT, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_RT)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_SG, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_SG)));
 } else if (ReportsConversation.FACILITY_LIST_RPRT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_CC, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_CC)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_CP, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_CP)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_MH, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_MH)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_SH, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_SH)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_OT, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_OT)));
 } else if (ReportsConversation.HOME_LIST_RPRT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_70, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_70)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_71, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_71)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_A, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_A)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_D, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_D)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_F, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_F)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_I, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_I)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_J, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_J)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_L, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_L)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_O, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_O))); 
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_APP, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_APP)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_PFA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PFA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_PSA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PSA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_PTA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PTA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_AFA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_AFA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_ASA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_ASA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_ATA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_ATA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_PCL, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PCL)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_CSD, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_CSD)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_WTL, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_WTL)));
 } else if (ReportsConversation.PROVIDER_LIST_RPRT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	resourceOptionList.add(new Option(CodesTables.CRSCTYPE_01, Lookup.simpleDecodeSafe(CodesTables.CRSCTYPE, CodesTables.CRSCTYPE_01)));
 	resourceOptionList.add(new Option(CodesTables.CRSCTYPE_02, Lookup.simpleDecodeSafe(CodesTables.CRSCTYPE, CodesTables.CRSCTYPE_02)));
 	resourceOptionList.add(new Option(CodesTables.CRSCTYPE_03, Lookup.simpleDecodeSafe(CodesTables.CRSCTYPE, CodesTables.CRSCTYPE_03)));
 	resourceOptionList.add(new Option(CodesTables.CRSCTYPE_04, Lookup.simpleDecodeSafe(CodesTables.CRSCTYPE, CodesTables.CRSCTYPE_04)));
 } else if (ReportsConversation.DIV_ACT_CASE_STAT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	caseStatusOptionList.add(new Option(blankValueDefault, cdAllCases));
 	caseStatusOptionList.add(new Option(ArchitectureConstants.N, cdOpenCases));
 	caseStatusOptionList.add(new Option(ArchitectureConstants.Y, cdClosedCases)); 	 	
 } else if (ReportsConversation.CASE_WO_FTM_SQR_NAME.equals(hdnNmRptSqrName)) {
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FPR, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FPR)));
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FSU, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FSU)));
 } else if (ReportsConversation.FTM_WO_PARENT_PARTICIPATION_RPT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FPR, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FPR)));
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FSU, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FSU)));
 } else if (ReportsConversation.EDUCATION_DETAIL_RPT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FPR, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FPR)));
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FSU, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FSU)));
 }
 
 // Contains drop down parameter name and corresponding option or sub list. Any new entry in this list should have a corresponding entry in the
 // paramCodesTablesMap list but not vice versa.
 HashMap<String, List<Option>> paramOptionMap = new HashMap<String, List<Option>>();
 paramOptionMap.put("CATEGORYCD", catOptionList);
 paramOptionMap.put("FACILITYCD", facilOptionList);
 paramOptionMap.put("FAHOMESTATUSCD", statusOptionList);
 paramOptionMap.put("RESOURCETYPECD", resourceOptionList);
 // SMS #54117 "STATUSCASECD" parameter does not have corresponding CODES_TABLES value; 
 // no need to have paramCodesTablesMap value
 paramOptionMap.put("STATUSCASECD", caseStatusOptionList);
 paramOptionMap.put("STAGECD", stageOptionList); //SMS 78537
  
 // Contains codes tables name for drop down parameters. Used for reports display full codes list
 // An entry in here does not require an corresponding entry in the paraOptionMap list
 // Also this is for parameters that do not require default value
 HashMap<String, String> paramCodesTablesMap = new HashMap<String, String>();
 paramCodesTablesMap.put("CATEGORYCD", "CFACATEG");
 paramCodesTablesMap.put("FACILITYCD", "CFACTYP4");
 paramCodesTablesMap.put("FAHOMESTATUSCD", "CFAHMSTA");
 paramCodesTablesMap.put("RESOURCETYPECD", "CRSCTYPE");
 paramCodesTablesMap.put("INVTYPECD", "CINVSRTP");
 paramCodesTablesMap.put("INVPHASECD", "CINVSRCH");
 paramCodesTablesMap.put("TCMDENIALREASONCD", "CTCMDEN");
 paramCodesTablesMap.put("STAGECD", "CSTAGES"); //SMS 78537
 %>

<script type="text/javascript">


// The setParameters function loops through the input fields constructing a string that
// will be passed to the ReportsConversation.  The format is param1^param2^.  Since the parameters
// are listed on the page in order needed by the SQR program this approach works effectively.
function setParameters(){
  var parmString = "";
  for (i=0; i < frmReportParameters.elements.length; i++)
  {
    var formElement = frmReportParameters.elements(i);
    var inputName = formElement.name;
    var index = inputName.indexOf("parm");
    var elementValue = "";
    if (index == 0) {
      //Set defaults for null fields.
      if (inputName == "parmMONTHYEAR" && formElement.value == ""){
        elementValue = "12/4712";
      }
      else if (formElement.value == "") {
        elementValue = "0";
      }
      else {
        elementValue = formElement.value;
      } 
      parmString = parmString + elementValue + "^";
    }
  }
  // Encode the string
  parmString = escape(parmString);
  frmReportParameters.txtRptParmList.value = parmString;
  return true;
}
</script>

<impact:validateErrors formName="frmReportParameters"/>

<impact:validateForm name="frmReportParameters"
   method="post"
   action=""
   schema="/WEB-INF/Constraints.xsd"
   pageMode="<%= pageMode %>"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsCustomValidation"
   redisplayParameters="true">
<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="ulIdPerson" value="<%= String.valueOf(user.getUserID())%>"/>
<impact:validateInput type="hidden" name="<%= ReportsConversation.REPORT_PARAM_NM_PERSON_FULL %>" value="<%= String.valueOf(user.getUserFullName()) %>"/>
<impact:validateInput type="hidden" name="szNmRptSqrName" value ="<%=hdnNmRptSqrName%>" />
<impact:validateInput type="hidden" name="szNmRptSqrVer" value="<%=hdnNmRptSqrVer%>"/>
<impact:validateInput type="hidden" name="szNmRptType" value="<%=hdnNmRptType%>"/>
<impact:validateInput type="hidden" name="txtRptParmList" value=""/>

<!--- Begin Detail Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
	  <th colspan="3"><%=reportName%></th>
  </tr>
  
  <%
    /**
    * While loop goes through the parameters for the report.  Depending on the name and type of parameter
    * the input element is created.
    */
    while (parmIterator.hasNext())
    {
      RetrieveReportParametersSO rrpSO = parmIterator.next();
      String paramName = rrpSO.getNmRptParmName();
      String paramNameRequest = "param" + paramName;
  %>
  <%
      if ("DATE".equals(rrpSO.getTxtRptParmType()))
      { %>
        <tr>
          <td width="25%">
          &nbsp;
          </td>
	      <td>
            <impact:validateDate 
	           size="10" 
		       value="" 
		       disabled="false" 
		       required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>"
		       conditionallyRequired="<%= ("C".equals(rrpSO.getIndRequired())) ? "true" : "false" %>"
		       label="<%= rrpSO.getNmRptParmLabel() %>" 
		       name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
		       tabIndex="<%= tabIndex++%>" 
		       constraint="Date" />
	   </td>
        </tr>  
   
     <%} else if ("MONTHYEAR".equals(rrpSO.getNmRptParmName())) { %>
       <tr>
        <td width="25%">
          &nbsp;
         </td>      
	     <td>
	       <impact:validateInput size="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>" 
	         value=""
	         type="text" 
	         disabled="false" 
	         label="<%= rrpSO.getNmRptParmLabel() %>" 
	         name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
	         tabIndex="<%= tabIndex++%>" 
	         required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>"
	         maxLength="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>"
	         constraint="MonthYear"/>
	     </td>
       </tr>
     <% // STGAP00013351 - added 2 new param name so that constraint error message can display the label for reports that have 2+ monthyear params
     } else if ("STARTMMYYYY".equals(rrpSO.getNmRptParmName())) { %>
       <tr>
        <td width="25%">
          &nbsp;
         </td>      
	     <td>
	       <impact:validateInput size="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>" 
	         value=""
	         type="text" 
	         disabled="false" 
	         label="<%= rrpSO.getNmRptParmLabel() %>" 
	         name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
	         tabIndex="<%= tabIndex++%>" 
	         required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>"
	         maxLength="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>"
	         constraint="MonthYear"/>
	     </td>
       </tr>
     <%} else if ("ENDMMYYYY".equals(rrpSO.getNmRptParmName())) { %>
       <tr>
        <td width="25%">
          &nbsp;
         </td>      
	     <td>
	       <impact:validateInput size="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>" 
	         value=""
	         type="text" 
	         disabled="false" 
	         label="<%= rrpSO.getNmRptParmLabel() %>" 
	         name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
	         tabIndex="<%= tabIndex++%>" 
	         required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>"
	         maxLength="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>"
	         constraint="MonthYear"/>
	     </td>
       </tr>
     <%} else if (("COUNTYCD".equals(rrpSO.getNmRptParmName()))) {%>
        <tr>
         <td width="25%">
           &nbsp;
         </td>        
	     <td>    
   		  <impact:validateSelect label="County" 
   		      required="false" blankValue="true" 
   		      name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
   		      codesTable="CCOUNT" 
   		      value="<%= userCounty %>"
   		      required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
   		      tabIndex="<%= tabIndex++ %>"/>   
	     </td>
       </tr>     
     <%} else if (("REGIONCD".equals(rrpSO.getNmRptParmName()))) {%>     
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>    
           <impact:validateSelect blankValue="true"
                               label="Region"
                               name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
                               value="<%= userRegion %>"
                               tabIndex="<%= tabIndex++ %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
                               conditionallyRequired="<%= ("C".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
             				   codesTable="CREGIONS"/>     
	     </td>
       </tr>
     <%} else if ("UNIT".equals(rrpSO.getNmRptParmName())) { %>
       <tr>
        <td width="25%">
          &nbsp;
         </td>      
	     <td>
	       <impact:validateInput size="2" 
	         value=""
	         type="text" 
	         disabled="false" 
	         label="Unit" 
	         name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
	         tabIndex="<%= tabIndex++%>" 
	         required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>"
	         maxLength="2"
	         constraint="AlphaNumeric2Unit"/>
	     </td>
       </tr>       
      <%} else if("STAFFID".equals(rrpSO.getNmRptParmName())){ %> 
	<!--STGAP00006764 staff Id requires select resource button-->
       <tr>
        <td width="25%">
          &nbsp;
         </td>
	     <td>
	       <impact:validateInput size="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>" 
	         value="<%=staffIdString%>" 
	         type="text" 
	         disabled="false" 
	         label="<%= rrpSO.getNmRptParmLabel() %>" 
	         name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
	         tabIndex="<%= tabIndex++%>" 
	         required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>"
	         maxLength="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>"/>
	     </td>
        </tr>
        <tr>
        <td width="25%">
          &nbsp;
         </td>
	     <td>	
         <impact:ButtonTag name="btnSelectStaff"
                                img="btnSelectStaff"
                                tabIndex="<%=tabIndex++%>"
                                disabled="false"
                                form="frmReportParameters"
                                restrictRepost="true"
                                function="disableValidation('frmReportParameters');"
				preventDoubleClick="true"
				action="/admin/Reports/displayStaffList" />
	     </td>
        </tr>	      
      <%// SMS#51990:: general logic for codes tables parameters
      } else if ((StringHelper.isValid(paramName)) && 
     (paramCodesTablesMap.containsKey(paramName) ) )  { 
               if (paramOptionMap.containsKey(paramName) && paramOptionMap.get(paramName).size() > 0) {// extra check  for size > 0 even though a full code list parameter should not be in this option map list
      %>
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>    
           <impact:validateSelect blankValue="true"
                               label="<%= rrpSO.getNmRptParmLabel() %>"
                               name="<%= "parm" + paramName %>" 
                               options="<%= paramOptionMap.get(paramName) %>"
                               tabIndex="<%= tabIndex++ %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" />     
	     </td>
       </tr>      
       		<%} else { %>
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>    
           <impact:validateSelect blankValue="true"
                               label="<%= rrpSO.getNmRptParmLabel() %>"
                               name="<%= "parm" + paramName %>" 
                               tabIndex="<%= tabIndex++ %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
                               codesTable="<%= paramCodesTablesMap.get(paramName) %>"/>     
	     </td>
       </tr>      
     <!-- STGAP00013607 - invoice report: replaced with general logic above -->
      <% // SMS #54117 The default value for the dropdown is "All" cases
      } } else if (("STATUSCASECD".equals(rrpSO.getNmRptParmName())) && (StringHelper.isValid(paramName)) 
      && (paramOptionMap.containsKey(paramName) 
      && paramOptionMap.get(paramName).size() > 0)) {
      %>
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>    
           <impact:validateSelect blankValue="false"
                               label="<%= rrpSO.getNmRptParmLabel() %>"
                               name="<%= "parm" + paramName %>" 
                               value="<%= FormattingHelper.formatString(rrpSO.getTxtRptParmType().valueOf(blankValueDefault)) %>"
                               options="<%= paramOptionMap.get(paramName) %>"
                               tabIndex="<%= tabIndex++ %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" />     
	     </td>
       </tr>      
      <!--SMS# 74618 - Special Inv Report drop down parameter    -->       
       <%} else if ("SPECINVTYPE".equals(rrpSO.getNmRptParmName())) 
      { %>     
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>    
           <impact:validateSelect blankValue="true"
                               label="<%= rrpSO.getNmRptParmLabel() %>"                       
                               name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
                               tabIndex="<%= tabIndex++ %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
                               codesTable="CSPECREQ"/>     
	     </td>
       </tr>
      <!--  MR-34 and MR-59 - PPA report (SMS45483): new parameter drop down-->
      <% } else if (("INVADJCD".equals(rrpSO.getNmRptParmName()))) {%>     
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>    
           <impact:validateSelect blankValue="true"
                               label="<%= rrpSO.getNmRptParmLabel() %>"
                               name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
                               tabIndex="<%= tabIndex++ %>"
                               excludeOptions="<%= excludeINVADJCD %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
                               codesTable="CINVADJT"/>     
	     </td>
       </tr>
      <!--  STGAP00013184 - TCM report: replaced with general logic above -->
      <!--  STGAP00015328 - Case Review List report (MR-056) -->
     <% } else if (("CASEREVIEWTYPECD".equals(rrpSO.getNmRptParmName()))) {%>     
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>    
           <impact:validateSelect blankValue="true"
                               label="<%= rrpSO.getNmRptParmLabel() %>"
                               name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
                               value="<%= CodesTables.CCSRTYPE_RT4 %>"
                               tabIndex="<%= tabIndex++ %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
                               codesTable="CCSRTYPE"/>     
	     </td>
       </tr>
      <!--   end STGAP00015328-->
      <!-- Begin Adding three new types for Case Watch Activity Report -->
     <% } else if (("ERRWARN".equals(rrpSO.getNmRptParmName()))) {%>     
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>
           <impact:validateSelect blankValue="false"
                               label="<%= rrpSO.getNmRptParmLabel() %>"
                               name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
                               value="<%= CodesTables.CERRWARN_ALL %>"
                               tabIndex="<%= tabIndex++ %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
                               codesTable="CERRWARN"/>     
	     </td>
       </tr>
     <% } else if (("OPNCLDSTG".equals(rrpSO.getNmRptParmName()))) {%>     
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>    
           <impact:validateSelect blankValue="false"
                               label="<%= rrpSO.getNmRptParmLabel() %>"
                               name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
                               value="<%= CodesTables.COPCLSTG_OPNONLY %>"
                               tabIndex="<%= tabIndex++ %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
                               codesTable="COPCLSTG"/>     
	     </td>
       </tr>
     <% } else if (("ERRWARNTYP".equals(rrpSO.getNmRptParmName()))) { %>     
        <tr>
         <td width="25%">
          &nbsp;
         </td>   
	     <td>    
           <impact:validateSelect blankValue="false"
                               label="<%= rrpSO.getNmRptParmLabel() %>"
                               name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
                               value="<%= CodesTables.CERWRTYP_ALL %>"
                               tabIndex="<%= tabIndex++ %>"
                               required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
                               codesTable="CERWRTYP"/>     
	     </td>
       </tr>
       <tr>
       <td colspan="2">
       </td>
       	<td>
			<impact:validateDisplayOnlyField name="dspUdr2TipText"
				value="<%="When using date Parameters, Errors Only and All Open/Closed Stages must be selected"%>"/>       		
       	</td>
       </tr>
      <!-- End Adding three new types for Case Watch Activity Report -->                           
      <% 
      	//Adding Tool Tip for Case Watch UDR Report
      	udrMessage = "Tip: To ensure your report does not return error message: 'Report exceeds limit of 65,000 rows of data,' you may need to input narrower Report Parameter search criteria (i.e. reduce number of regions, counties, case managers or time period).";
      
      } else {%>       
       <tr>
        <td width="25%">
          &nbsp;
         </td>
	     <td>
	       <impact:validateInput size="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>" 
	         value=""
	         type="text" 
	         disabled="false" 
	         label="<%= rrpSO.getNmRptParmLabel() %>" 
	         name="<%= "parm" + rrpSO.getNmRptParmName() %>" 
	         tabIndex="<%= tabIndex++%>" 
	         required="<%= ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" %>"
	         conditionallyRequired="<%= ("C".equals(rrpSO.getIndRequired())) ? "true" : "false" %>" 
             maxLength="<%= String.valueOf(rrpSO.getNbrRptParmLength()) %>"/>
	     </td>
        </tr>
			
	
       <%}%>     
     
 <%}// End while loop%> 
 
</table>
<% // // STGAP00012549
if (hasOptionalRegionCountyParm || hasOptionalRegionOnly) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%"> 
 <tr>
   <td>
				<impact:validateDisplayOnlyField name="dspTipText"
					value="<%=statewideMessage%>"/>
   </td>
 </tr>
 <tr>
   <td>
				<impact:validateDisplayOnlyField name="dspUdrTipText"
					value="<%=udrMessage%>"/>
   </td>
 </tr> 
</table>
<% } %>
<% // end STGAP00012549 %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td width="72%">&nbsp;</td>
    <td class="alignRight" width="10%">&nbsp;</td>
    <td class="alignRight" width="18%">                    
      <impact:ButtonTag name="btnLaunch"
                        img="btnLaunch"
                        align="right"
                        form="frmReportParameters"
                        action="/admin/Reports/launcherGenerate"
                        tabIndex="<%= tabIndex++ %>"
                        backSafe="false"
                        function="javascript:setParameters();"/>
    </td>
  </tr>
</table>
<br/>
</impact:validateForm>
<!--- End Detail Table --->
