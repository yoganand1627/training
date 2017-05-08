package org.apache.jsp.grnds_002ddocs.casemgmt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.casemgmt.FCGSSubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FCCPFamilyDetailConversation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FCGSSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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
BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      FCGSRetrieveSO fcgsretso = (FCGSRetrieveSO) state.getAttribute("FCGSRetrieveSO", request);

      int count = 0;
      int idEvent = fcgsretso.getUlIdEvent();
      int loopCount = 0;
      int size = 0;
      List<GoalsBean> goalBeanList = fcgsretso.getGoalBeanList();
      List<GoalsBean> specficGoalList = new ArrayList<GoalsBean>();
      List<GoalsBean> specficGoalListNre = new ArrayList<GoalsBean>();
      List<String> existingRsnList = new ArrayList<String>();
      String editableMode = ArchitectureConstants.TRUE;
      String goalReason = "";
      String includingFormName = (String) request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);
      String pageMode = PageModeConstants.MODIFY;
      String planType = "";
      String selGReason = "";
      String tabindexString = (String) request.getAttribute("tabIndex");
      int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);

      if (idEvent != 0) {
        GlobalData.setUlIdEvent(idEvent, request);
      }
      if ((String) state.getAttribute(FCGSSubmoduleConversation.PAGE_MODE_KEY, request) != null
          || (String) state.getAttribute(FCGSSubmoduleConversation.PAGE_MODE_KEY, request) != "") {
        pageMode = (String) state.getAttribute(FCGSSubmoduleConversation.PAGE_MODE_KEY, request);
      }
      if (PageModeConstants.MODIFY.equals(pageMode)) {
        editableMode = "false";
      }

      planType = (String) state.getAttribute(FCCPFamilyDetailConversation.CASE_PLAN_MODE, request);

      out.write("\r\n\r\n<script language=\"Javascript\">\r\nfunction launchFCGSDetail( index, indicator)\r\n{\r\n  document.");
      out.print( includingFormName );
      out.write(".hdnNreIndicator.value = indicator;\r\n  document.");
      out.print( includingFormName );
      out.write(".fcgsIndex.value = index;\r\n  document.");
      out.print( includingFormName );
      out.write(".isAddFCGS.value = 'false';\r\n  disableValidation( '");
      out.print( includingFormName );
      out.write("' );\r\n  submitValidateForm('");
      out.print( includingFormName );
      out.write("', '/casemgmt/FCGSDetail/displayFCGSDetail');\r\n  \r\n}\r\nfunction addFCGSDetail()\r\n{\r\n  document.");
      out.print( includingFormName );
      out.write(".isAddFCGS.value = 'true';\r\n  return true;\r\n}\r\n\r\nfunction addReFCGSDetail()\r\n{\r\n  document.");
      out.print( includingFormName );
      out.write(".isAddFCGS.value = 'true';\r\n  document.");
      out.print( includingFormName );
      out.write(".hdnCDGoalRsnNre.value=\"\";\r\n  document.");
      out.print( includingFormName );
      out.write(".hdnNreIndicator.value = 'false';\r\n  CleanSelect(document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsn);\r\n  CleanSelect(document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsnNre);\r\n  return true;\r\n}\r\nfunction addNreFCGSDetail()\r\n{\r\n  document.");
      out.print( includingFormName );
      out.write(".isAddFCGS.value = 'true';\r\n  document.");
      out.print( includingFormName );
      out.write(".hdnCDGoalRsn.value=\"\";\r\n  document.");
      out.print( includingFormName );
      out.write(".hdnNreIndicator.value = 'true';\r\n  CleanSelect(document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsn);\r\n  CleanSelect(document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsnNre);\r\n  return true;\r\n}\r\nfunction updateReasonRe()\r\n{\r\n   var type = \"REU\";\r\n   var selGReason = document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsn.value;\r\n   document.");
      out.print( includingFormName );
      out.write(".hdnCDGoalRsn.value=selGReason;\r\n   document.");
      out.print( includingFormName );
      out.write(".hdnGoalType.value=type;\r\n   CleanSelect(document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsn);\r\n  CleanSelect(document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsnNre);\r\n}\r\nfunction updateReason()\r\n{\r\n   var selGReason = document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsn.value;\r\n   document.");
      out.print( includingFormName );
      out.write(".hdnCDGoalRsn.value=selGReason;\r\n   CleanSelect(document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsn);\r\n}\r\nfunction updateReasonNre()\r\n{\r\n  var type = \"NRE\";\r\n  var selGReason = document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsnNre.value;\r\n  document.");
      out.print( includingFormName );
      out.write(".hdnCDGoalRsnNre.value=selGReason; \r\n  document.");
      out.print( includingFormName );
      out.write(".hdnGoalType.value=type;\r\n  CleanSelect(document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsn);\r\n  CleanSelect(document.");
      out.print( includingFormName );
      out.write(".szCdGoalRsnNre);\r\n}\r\n\r\n</script>\r\n");
      if (_jspx_meth_impact_validateInput_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
String goalType = "";
      //Depending on the page calling this sub the goal Type is set.
      if ("frmChildPlan".equals(includingFormName)) {
        goalType = "DFC";
      } else if ("frmFCCPFamilyDetail".equals(includingFormName)) {
        goalType = "REU";
        //In case of FCCPFamily Detail 2 sections with goal types REU and 
        //NRE should be displayed and hence the counter is incremented to 1.
        count = 1;
      } else if ("frmWTLP".equals(includingFormName)) {
        goalType = "WTL";
      }

      for (int i = 0; i <= count; i++) {

        if ("AFC".equals(planType) && i == 0) {
          count = 0;
          goalType = "AFC";
        }
        //When the parent page is FCCPFamily Detail first the reunification section is displayed and when it 
        //enters the for loop for the second time the goal type is set to NRE to display the Nonreunification section.
        if (i == 1) {
          goalType = "NRE";
          loopCount = 0;
        }

        if (goalBeanList != null) {
          //when it enters the for loop the second time for NRE the goal list still contains the REU goals 
          //So it is re-initialized
          if (i == 1 && !specficGoalList.isEmpty()) {
            specficGoalList = new ArrayList();
          }
          for (Iterator<GoalsBean> it = goalBeanList.iterator(); it.hasNext();) {
            GoalsBean goalRow = (GoalsBean) it.next();
            if (FormattingHelper.formatString(goalRow.getCdGoalTyp()).equals(goalType)) {
              specficGoalList.add(goalRow);
            }
          }
        }
        //As the reunification and nonreunification sections are displayed on the same parent page the NRE 
        //goals should be saved in the state with a different name.
        if ("NRE".equals(goalType)) {
          state.setAttribute("specficGoalListNre", specficGoalList, request);
        } else {
          state.setAttribute("specficGoalList", specficGoalList, request);
        }
        size = specficGoalList.size();
        String goalLabel = "";
        String codesTable = "";

        //Depending on the goal type the reason codes tables and the expandable section labels
        //are set.

        if (goalType.equals("REU")) {
          goalLabel = "Reunification";
          codesTable = "CRURSN";
        } else if (goalType.equals("NRE")) {
          goalLabel = "Non-reunification";
          codesTable = "CNRRSN";
        } else if (goalType.equals("WTL")) {
          goalLabel = "WTLP Goals";
          codesTable = "CWTLPGLS";
        } else if (goalType.equals("DFC")) {
          goalLabel = "DFCS Standard Goals";
        } else if (goalType.equals("AFC")) {
          goalLabel = "AFC Goals";
        }

        
      out.write('\r');
      out.write('\n');
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName( goalType );
      _jspx_th_impact_ExpandableSectionTag_0.setId("goalItem_0");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel( goalLabel );
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t<div id=\"scrollBar\" style=\"height:165px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tGoal\r\n\t\t\t\t</th>\r\n\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\tChange\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t");
if (!FormValidation.pageHasErrorMessages(request)) {
          if (size == 0) {

          out.write("\r\n\t\t\t<tr class=\"odd\">\r\n\t\t\t\t<td colspan=\"7\">\r\n\t\t\t\t\t");
          out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t");
} else {
            for (Iterator<GoalsBean> it = specficGoalList.iterator(); it.hasNext();) {
              GoalsBean goalRow = (GoalsBean) it.next();
              int idGoal = goalRow.getIdGoal();

          out.write("\r\n\t\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1));
          out.write("\">\r\n\t\t\t\t<td width=\"35%\" align=\"left\">\r\n\t\t\t\t\t");
String goalText = "";
              String rsnCodesTable = "";
              String goalReasonCode = "";
              if (goalType.equals("DFC")) {
                goalReason = "DFCS Standard";
              } else if (goalType.equals("AFC")) {
                goalReason = "AfterCare";
              } else {
                goalReasonCode = FormattingHelper.formatString(goalRow.getCdGoalRsn());
              }
              if ("NRE".equals(goalType)) {
                goalReason = Lookup.simpleDecodeSafe(CodesTables.CNRRSN, goalReasonCode);
              } else if ("REU".equals(goalType)) {
                goalReason = Lookup.simpleDecodeSafe(CodesTables.CRURSN, goalReasonCode);
              } else if ("WTL".equals(goalType)) {
                goalReason = Lookup.simpleDecodeSafe(CodesTables.CWTLPGLS, goalReasonCode);
              }
              //There can be only one goal per reason. So all the existing reasons are saved in the existingRsnList
              //and when the user tries to add another goal selecting the reason from the dropdown box, the selected reason is 
              //looked up against the list and if it already exists then an error message is displayed.
              existingRsnList.add(goalReason);
              //The Change column in the list section is populated by the first 100 characters of the goal text.
              String temp = FormattingHelper.formatString(goalRow.getLdTxtGoal());
              if (temp.length() > 100) {
                goalText = temp.substring(0, 100);
              } else {
                goalText = temp;
              }
              String goalReasonDisplay;
              if (goalReason.length() > 50) {
                goalReasonDisplay = goalReason.substring(0, 50);
              } else {
                goalReasonDisplay = goalReason;
              }
              String listItemId = "reunificationItem_" + loopCount;
              String nreIndicator = "";
              if ("NRE".equals(goalType)) {
                nreIndicator = "true";
              } else {
                nreIndicator = "false";
              }

          out.write("\r\n\t\t\t\t\t<a href=\"javascript:launchFCGSDetail('");
          out.print( loopCount );
          out.write("', '");
          out.print( nreIndicator );
          out.write("');\" tabIndex=\"");
          out.print( tabIndex );
          out.write("\" id=\"");
          out.print( listItemId );
          out.write('"');
          out.write('>');
          out.print(goalReasonDisplay);
          out.write("</a>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td nowrap=\"nowrap\">\r\n\t\t\t\t\t");
          out.print(goalText);
          out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t</tr>\r\n\r\n\t\t\t");
loopCount++;
            } // end while enumeration has more elements
            state.setAttribute("existingReasonList", existingRsnList, request);
          } //end big else
        } // end !FormValidation.pageHasErrorMessages

        
          out.write("\r\n\t\t</table>\r\n\t</div>\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t");
if (!"DFC".equals(goalType) && !"AFC".equals(goalType) && !"NRE".equals(goalType)) { 
          out.write("\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
String functionCall = "";
          if ("REU".equals(goalType)) {
            functionCall = "updateReasonRe();";
          } else {
            functionCall = "updateReason();";
          }

          
          out.write("\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setDisabled( "" );
          _jspx_th_impact_validateSelect_0.setId("szCdGoalRsn");
          _jspx_th_impact_validateSelect_0.setName("szCdGoalRsn");
          _jspx_th_impact_validateSelect_0.setWidth("20%");
          _jspx_th_impact_validateSelect_0.setOnChange( functionCall );
          _jspx_th_impact_validateSelect_0.setValue("");
          _jspx_th_impact_validateSelect_0.setCodesTable( codesTable );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnCDGoalRsn");
          _jspx_th_impact_validateInput_3.setValue( selGReason );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t");
} else if ("NRE".equals(goalType)) {
          //As the reunification and the nonreunification sections are on the same page the drop down box and the Add button
          // should have a different name for nonreunification section.

          
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setDisabled( "" );
          _jspx_th_impact_validateSelect_1.setId("szCdGoalRsnNre");
          _jspx_th_impact_validateSelect_1.setName("szCdGoalRsnNre");
          _jspx_th_impact_validateSelect_1.setWidth("20%");
          _jspx_th_impact_validateSelect_1.setOnChange("updateReasonNre()");
          _jspx_th_impact_validateSelect_1.setValue("");
          _jspx_th_impact_validateSelect_1.setCodesTable( codesTable );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnCDGoalRsnNre");
          _jspx_th_impact_validateInput_4.setValue( selGReason );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t");
}

        
          out.write("\r\n\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnGoalType");
          _jspx_th_impact_validateInput_5.setValue( goalType );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\r\n\r\n\t\t\t");
if (!pageMode.equals(PageModeConstants.VIEW)) {
			// STGAP00010974 Displaying add button only after the page has been saved first. 
			  String displayAddBtn; 
			  Boolean updateClicked = (Boolean) state.getAttribute("BTN_UPDATE_CLICKED", request);
			  Boolean copyClicked = (Boolean) state.getAttribute("BTN_COPY_CLICKED", request);
			  Boolean wtlpCopyClicked = (Boolean) state.getAttribute("WTLP_COPY_CLICKED", request);
			  
			  //STGAP00013838: when we access "Foster Care Goal/Step Detail" page 
			        //through "WTLP" page or "Foster Care Case Plan Child" page  there is no update button, hence 
			        //we have to initialize "updateClicked" to false.
			        if (updateClicked == null) {
			          updateClicked = false;
			        }
			        if (copyClicked == null) {
			          copyClicked = false;
			        }
			         if (wtlpCopyClicked == null) {
			          wtlpCopyClicked = false;
			        }
			        
         		 if(idEvent == 0 || updateClicked || copyClicked || wtlpCopyClicked){
         				displayAddBtn = ArchitectureConstants.TRUE ;
          			}else{
          					displayAddBtn = ArchitectureConstants.FALSE;  
          				 }
          if ("NRE".equals(goalType)) { 
         
          out.write("\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAddNewNreGoal");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setDisabled( displayAddBtn );
          _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm( includingFormName );
          _jspx_th_impact_ButtonTag_0.setFunction("return addNreFCGSDetail();");
          _jspx_th_impact_ButtonTag_0.setAction("/casemgmt/FCGSDetail/displayFCGSDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
} else {
            if ("REU".equals(goalType)) {
          out.write("\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAddNewGoal");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_1.setDisabled( displayAddBtn );
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm( includingFormName );
          _jspx_th_impact_ButtonTag_1.setFunction("return addReFCGSDetail();");
          _jspx_th_impact_ButtonTag_1.setAction("/casemgmt/FCGSDetail/displayFCGSDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
} else {
          out.write("\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_2.setName("btnAddNewGoal");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_2.setDisabled( displayAddBtn );
          _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm( includingFormName );
          _jspx_th_impact_ButtonTag_2.setFunction("return addFCGSDetail();");
          _jspx_th_impact_ButtonTag_2.setAction("/casemgmt/FCGSDetail/displayFCGSDetail");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t");
}
           
			}
				} 
          out.write("\r\n\t\t</tr>\r\n\r\n\t</table>\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
//This is to add a space bar between the two sections in case of FCCPFamily Detail.
        if ("REU".equals(goalType)) { 
      out.write("\r\n<br>\r\n");
}
      } 
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

  private boolean _jspx_meth_impact_validateInput_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent(null);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("fcgsIndex");
    _jspx_th_impact_validateInput_0.setValue("0");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent(null);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("isAddFCGS");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent(null);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnNreIndicator");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
