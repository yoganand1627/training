package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fad.FAHomeValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.fad.FAHomeSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import java.util.Comparator;
import org.exolab.castor.types.Date;

public final class FAHomeSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
//  Declare variables
      int tabIndex = 1;
      String TRACE_TAG = "FAHomeSearch.jsp";
      //  Set the page mode
      String pageMode = PageModeConstants.EDIT;
      String formName = "frmFaHomeSearch";
      List faHomeList = null;
      Object results = null;

      String szNmResource = null;
      String ulIdResource = null;
      String szCdRsrcFaHomeStatus = null;
      String szCdRsrcRegion = null;
      String szCdRsrcCnty = null;
      String szCdRsrcCategory = null;
      String szAddrRsrcAddrCity = null;
      String cCdRsrcFaHomeType1 = null;
      String szCdRsrcLanguage = null;
      String nbrRsrcFacilCapacity = null;
      String cCdPersonSex = null;
      String sMinMonth = null;
      String sMaxMonth = null;
      String nbrChildPersonId =null;
      String szChildName = null;
      String nbrChildAge = null;
      String dtChildDob =null;
      String sMinYear = null;
      String sMaxYear = null;
      boolean sIsThereResult = true;
      String isHomeTypeDisabled = "false";
      String szCdMaritalStatus = null;
      String szCdSchoolDistrict = null;
      String sRegAdptnExchange = null;
   //   String checkRegAdptnExchgneYes = null;
   //   String checkRegAdptnExchgneNo = null;
      String nbrRsrcFacilOpenSlots = null;
      String nbrRsrcFacilCurrPlcmnts = null;
	  ROWCFAD07SOG02 thisCharacteristic = null;
      Date dtInquiryDate = null;
      String szCdReligion = "";
      String cdEthnicity = null;
      List<String> szCdRace = null;
	  List<String> szCdEthnicity = new ArrayList<String>();
      List<String> cdCharaCodes = null;
	  Comparator<CodeAttributes> sortDecode = new Comparator<CodeAttributes>(){
  public int compare(CodeAttributes c1, CodeAttributes c2) {
    return c1.getDecode().compareTo(c2.getDecode());
  }
};
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);

      if (request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME) != null) {
        results = request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);
      }

      if (request.getAttribute(FAHomeSearchConversation.FA_HOME_LIST) != null) {
        faHomeList = ((PaginationResultBean) results).getResults();
      }
      // SIR#19440: added the boolean bAddButton
      boolean bAddButton = (userProfile.hasRight(UserProfile.SEC_EMERG_PLCMT) && userProfile
                                                                                            .hasRight(UserProfile.SEC_MTN_HOME))
                           || userProfile.hasRight(UserProfile.SEC_MTN_HOME);

      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      List checkedValues = (List) state.getAttribute("checkedValues", request);

      SortedMap years = (SortedMap) state.getAttribute("years", request);
      SortedMap months = (SortedMap) state.getAttribute("months", request);

      Collection yearOptions = years.values();
      Collection monthOptions = months.values();
      Object object = state.getAttribute("searchBean", request);
      String resourceName = "/" + FAHomeValueBean.class.getName().replace('.', '/') + ".class";
	  
	  	szChildName = (String) state.getAttribute("txtSzNmChildName", request);
		
	    nbrChildAge = (String) state.getAttribute("txtSzNmChildAge", request);
		
		dtChildDob = (String) state.getAttribute("txtSzNmChildDob", request);
		
		szCdRace = (List<String>) state.getAttribute("listRaces", request);
		
		cdEthnicity = (String) state.getAttribute("txtSzEthnicity", request);
		
		cCdPersonSex = (String) state.getAttribute("selCCdPersonSex", request);
		
		if(cdEthnicity != null){
		szCdEthnicity.add(cdEthnicity);
        }

      FAHomeValueBean searchBean = (FAHomeValueBean) object;

      if (searchBean != null) {
        if (searchBean.getCity() != null) {
          szAddrRsrcAddrCity = searchBean.getCity();
        }
        if (searchBean.getFaHomeStatus() != null) {
          szCdRsrcFaHomeStatus = searchBean.getFaHomeStatus();
        }
        if (searchBean.getGender() != null) {
          cCdPersonSex = searchBean.getGender();
        }
        if (searchBean.getHomeResourceId() != 0) {
          ulIdResource = StringHelper.getSafeString(Integer.toString(searchBean.getHomeResourceId()));
        }
        if (searchBean.getLanguage() != null) {
          szCdRsrcLanguage = searchBean.getLanguage();
        }
        if (searchBean.getOpenSlot() != 0) {
          nbrRsrcFacilOpenSlots = StringHelper.getSafeString(Integer.toString(searchBean.getOpenSlot()));
        }
        if (searchBean.getRegion() != null) {
          szCdRsrcRegion = searchBean.getRegion();
        }
        if (searchBean.getResourceCategory() != null) {
          szCdRsrcCategory = searchBean.getResourceCategory();
        }
        if (searchBean.getResourceCounty() != null) {
          szCdRsrcCnty = searchBean.getResourceCounty();
        }
        if (searchBean.getResourceName() != null) {
          szNmResource = searchBean.getResourceName();
        }
        if (searchBean.getRsrcFaHomeType1() != null) {
          cCdRsrcFaHomeType1 = searchBean.getRsrcFaHomeType1();
        }
        if (searchBean.getMinAge() != 0) {
          sMinMonth = StringHelper.getSafeString(Integer.toString(searchBean.getMinAge() % 12));
          sMinYear = StringHelper.getSafeString(Integer.toString(searchBean.getMinAge() / 12));
        }

        if (searchBean.getMaxAge() != 0) {
          sMaxMonth = StringHelper.getSafeString(Integer.toString(searchBean.getMaxAge() % 12));
          sMaxYear = StringHelper.getSafeString(Integer.toString(searchBean.getMaxAge() / 12));
        }

        if (searchBean.getMaritalStatus() != null) {
          szCdMaritalStatus = searchBean.getMaritalStatus();
        }
        if (searchBean.getSchoolDistrict() != null) {
          szCdSchoolDistrict = searchBean.getSchoolDistrict();
        }
        if (searchBean.getInquiryDate() != null) {
          dtInquiryDate = searchBean.getInquiryDate();
        }
    //    if (searchBean.getIndRegAdptnExchge() != null)//depending on the value set the yes/no option bttns
    //    {
    //      if (searchBean.getIndRegAdptnExchge().equalsIgnoreCase(ArchitectureConstants.Y)) {
    //        checkRegAdptnExchgneYes = ArchitectureConstants.TRUE;
    //      } else {
    //        checkRegAdptnExchgneNo = ArchitectureConstants.TRUE;
    //      }
    //   }
        if (searchBean.getIntCapacity() != 0) {
          nbrRsrcFacilCapacity = StringHelper.getSafeString(Integer.toString(searchBean.getIntCapacity()));
        }
        if (searchBean.getICurrPlcmnts() != 0) {
          nbrRsrcFacilCurrPlcmnts = StringHelper.getSafeString(Integer.toString(searchBean.getICurrPlcmnts()));
        }
        if (searchBean.getReligion() != null) {
          szCdReligion = searchBean.getReligion();
        }
        if (searchBean.getEthnicityCriteria() != null && searchBean.getEthnicityCriteria().size() > 0) {
          szCdEthnicity = searchBean.getEthnicityCriteria();
        }

        
        if (searchBean.getRaceCriteria() != null && searchBean.getRaceCriteria().size() > 0) {
          szCdRace = searchBean.getRaceCriteria() ;
        }
        
      }
	  	if(szCdEthnicity == null && cdEthnicity != null){
             szCdEthnicity.add(cdEthnicity);
		  }
      // exlcude StateWidw Intake options from region  drop down list
      List<String> exOptions = new ArrayList<String>();
      exOptions.add(CodesTables.CSVCRGNS_00);
      
      // SMS #81140: MR-074 Filter Marital Status dropdown to exclude 'Unmarried Couple'
      List excludeFAMSTRC = new ArrayList();
	  excludeFAMSTRC.add(CodesTables.CFAMSTRC_19);
	 
	 // ECEM 5.0 Excluding None (non-special needs) from characteristics list.
	  List excludeCCHRTCA2 = new ArrayList();
	  excludeCCHRTCA2.add(CodesTables.OTH2_00);
	  
	  
	  List excludeGender = new ArrayList();
	  excludeGender.add(CodesTables.CSEX_U);
	 
	   
	  

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction onSearchClick(buttonClicked)\r\n{\r\n\r\n  enableValidation(\"");
      out.print( formName );
      out.write("\");\r\n  var minAgeYear = 0;\r\n  var minAgeMonth = 0;\r\n  var maxAgeYear = 0;\r\n  var maxAgeMonth = 0;\r\n  var selRsrcStatus = ");
      out.print(formName);
      out.write(".selSzCdRsrcFaHomeStatus.value;\r\n  // ECEM 5.0 checking for Approved (Full) - Active and Approved (Special) - Active\r\n   if ( selRsrcStatus == \"ASA\" || selRsrcStatus == \"AFA\" )\r\n   {\r\n   var bRetValue = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_RVW_CHARS) );
      out.write("');\r\n   if(!bRetValue){\r\n   return false;\r\n   }else{\r\n   \r\n   }\r\n   \r\n   }\r\n\r\n  \r\n  minAgeYear = (");
      out.print(formName);
      out.write(".cbxMinYear.value != \"\" ) ? ");
      out.print(formName);
      out.write(".cbxMinYear.value : minAgeYear;\r\n  minAgeMonth = (");
      out.print(formName);
      out.write(".cbxMinMonth.value != \"\" ) ? ");
      out.print(formName);
      out.write(".cbxMinMonth.value : minAgeMonth;\r\n  maxAgeYear = (");
      out.print(formName);
      out.write(".cbxMaxYear.value != \"\" ) ? ");
      out.print(formName);
      out.write(".cbxMaxYear.value : maxAgeYear;\r\n  maxAgeMonth = (");
      out.print(formName);
      out.write(".cbxMaxMonth.value != \"\") ? ");
      out.print(formName);
      out.write(".cbxMaxMonth.value : maxAgeMonth;\r\n\r\n  ");
      out.print(formName);
      out.write(".minAge.value = minAgeYear * 12 + parseInt(minAgeMonth);\r\n  ");
      out.print(formName);
      out.write(".maxAge.value = maxAgeYear * 12 + parseInt(maxAgeMonth);\r\n  \r\n  \r\n  \r\n  \r\n\r\n  if ( buttonClicked == 'S') {\r\n    ");
      out.print(formName);
      out.write(".cReqFuncCd.value = 'S';\r\n  } else {\r\n    ");
      out.print(formName);
      out.write(".cReqFuncCd.value = null;\r\n  }\r\n  return true;\r\n}\r\n\r\n function selectAll(catCode, numOfCheckboxes, checkValue) {\r\n  for ( i = 1; i <= numOfCheckboxes; i++ )\r\n  {\r\n\r\n    checkboxField = eval(\"frmFaHomeSearch.CharCbx\" + catCode + i);\t\r\n if (checkValue && checkboxField.checked != checkValue) {\r\n\tcheckboxField.click();\r\n\t}else if (checkboxField.checked != checkValue) {\r\n\tcheckboxField.click();\r\n\t}\r\n\t\r\n}\r\n\t\t}\r\n\t\t\r\n\t\t\r\n\t\tfunction expandAllCategories()\r\n{\r\nexpandCollapsed('expandedDED2','collapsedDED2' )\r\nexpandCollapsed('expandedEBD2','collapsedEBD2' )\r\nexpandCollapsed('expandedEXB2','collapsedEXB2' )\r\nexpandCollapsed('expandedFHI2','collapsedFHI2' )\r\nexpandCollapsed('expandedHVI2','collapsedHVI2' )\r\nexpandCollapsed('expandedMED2','collapsedMED2' )\r\nexpandCollapsed('expandedMER2','collapsedMER2' )\r\nexpandCollapsed('expandedOTH2','collapsedOTH2' )\r\n\r\n}\r\n\r\n\r\nfunction collapseAllCategories()\r\n{\r\nexpandCollapsed('collapsedDED2','expandedDED2' )\r\nexpandCollapsed('collapsedEBD2','expandedEBD2' )\r\nexpandCollapsed('collapsedEXB2','expandedEXB2' )\r\n");
      out.write("expandCollapsed('collapsedFHI2','expandedFHI2' )\r\nexpandCollapsed('collapsedHVI2','expandedHVI2' )\r\nexpandCollapsed('collapsedMED2','expandedMED2' )\r\nexpandCollapsed('collapsedMER2','expandedMER2' )\r\nexpandCollapsed('collapsedOTH2','expandedOTH2' )\r\n\r\n}\r\n\r\n\r\n/*\r\n*This function submits the form to bring up Home Info page for a new home.\r\n*/\r\n\r\nfunction submitFormForNewHome(cReqFuncCd)\r\n{\r\n  ");
      out.print( formName );
      out.write(".cReqFuncCd.value = cReqFuncCd;\r\n  return true;\r\n}\r\n\r\n/*\r\n*This function submits the form to bring up Home Info detail page.\r\n*/\r\nfunction submitFormToHomeDetail( indexNum, cReqFuncCd)\r\n{\r\n  ");
      out.print( formName );
      out.write(".indexNum.value = indexNum;\r\n  ");
      out.print( formName );
      out.write(".cReqFuncCd.value = cReqFuncCd;\r\n  submitValidateForm( \"");
      out.print( formName );
      out.write("\", \"/fad/FAHomeSearch/displayHomeInformationDetail\" );\r\n}\r\n\r\n\r\nfunction submitStage_ID(stageId)\r\n{\r\n  ");
      out.print( formName );
      out.write(".stageId.value = stageId;\r\n   // document.frmCallLog.personId.value = personId;\r\n    ");
      out.print( formName );
      out.write(".displayIntakeActionsFAHomeSearch.value = \"");
      out.print(ArchitectureConstants.Y);
      out.write("\";\r\n  ");
      out.print( formName );
      out.write(".intakeActionsPageMode.value = \"");
      out.print(PageModeConstants.VIEW);
      out.write("\";\r\n  submitValidateForm(\"");
      out.print( formName );
      out.write("\", \"/intake/IntakeActions/displayIntakeActions\");\r\n}\r\n\r\n\r\nfunction setHomeTypeDisable()\r\n{\r\n  if( ");
      out.print(formName);
      out.write(".selSzCdRsrcCategory.value == '");
      out.print(FAHomeValueBean.Adoptive);
      out.write("' ) {\r\n    ");
      out.print(formName);
      out.write(".selCCdRsrcFaHomeType1.value = \"\";\r\n    ");
      out.print(formName);
      out.write(".selCCdRsrcFaHomeType1.disabled = true;\r\n  } else {\r\n    ");
      out.print(formName);
      out.write(".selCCdRsrcFaHomeType1.disabled = false;\r\n  }\r\n\r\n}\r\n\r\nfunction setRegAdptExchng( itemSelected )\r\n{\r\n   ");
      out.print(formName);
      out.write(".rbIndRegAdptnExchge.value = itemSelected;\r\n   ");
      out.print(formName);
      out.write(".hdnIndRegAdptnExchge.value = itemSelected;\r\n}\r\n\r\n");
      out.write("\r\n  //Get county code/decode array with all data\r\n  ");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 01\r\n  ");
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 02\r\n  ");
      if (_jspx_meth_impact_codeArray_2(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 03\r\n  ");
      if (_jspx_meth_impact_codeArray_3(_jspx_page_context))
        return;
      out.write("  \r\n  //Get county code/decode array filtered for region 04\r\n  ");
      if (_jspx_meth_impact_codeArray_4(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 05\r\n  ");
      if (_jspx_meth_impact_codeArray_5(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 06\r\n  ");
      if (_jspx_meth_impact_codeArray_6(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 07\r\n  ");
      if (_jspx_meth_impact_codeArray_7(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 08\r\n  ");
      if (_jspx_meth_impact_codeArray_8(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 09\r\n  ");
      if (_jspx_meth_impact_codeArray_9(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 10\r\n  ");
      if (_jspx_meth_impact_codeArray_10(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 11\r\n  ");
      if (_jspx_meth_impact_codeArray_11(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 12\r\n  ");
      if (_jspx_meth_impact_codeArray_12(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 13\r\n  ");
      if (_jspx_meth_impact_codeArray_13(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 14\r\n  ");
      if (_jspx_meth_impact_codeArray_14(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 15\r\n  ");
      if (_jspx_meth_impact_codeArray_15(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 98\r\n  ");
      if (_jspx_meth_impact_codeArray_16(_jspx_page_context))
        return;
      out.write("\r\n\r\nfunction populateCounty(onPageLoad)\r\n{\r\n  if ( ");
      out.print(formName);
      out.write(".selSzCdRsrcRegion.value == ");
      out.print( CodesTables.CCOUNT_099 );
      out.write(" ||\r\n       ");
      out.print(formName);
      out.write(".selSzCdRsrcRegion.value == \"\") {\r\n    clearDropdown ( ");
      out.print(formName);
      out.write(".selSzCdRsrcCnty );\r\n  } else {\r\n    var dropdownValue = \"\";\r\n    if (onPageLoad && ");
      out.print( FAHomeSearchConversation.SEARCH_PAGE.equals(ContextHelper.getPreviousUrl(request)) ||
                          FAHomeSearchConversation.DISPLAY_SEARCH_PAGE.equals(ContextHelper.getPreviousUrl(request))  );
      out.write(") {\r\n      ");
 String dropdown = szCdRsrcCnty==null?request.getParameter("selSzCdRsrcCnty"):szCdRsrcCnty; 
      out.write("\r\n      dropdownValue = \"");
      out.print(dropdown);
      out.write("\";\r\n    }\r\n    populateDropdown(");
      out.print(formName);
      out.write(".selSzCdRsrcCnty, dropdownValue, eval(\"CCOUNT\"+");
      out.print(formName);
      out.write(".selSzCdRsrcRegion.value) );\r\n  }\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName(formName);
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fad/FAHomeSearch/faHomeSearch");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fad.FAHomeSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("indexNum");
          _jspx_th_impact_validateInput_3.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <input type=\"hidden\" name=\"stageId\" value=\"\">\r\n  <input type=\"hidden\" name=\"intakeActionsPageMode\" value=\"\">\r\n  <input type=\"hidden\" name=\"displayIntakeActionsFAHomeSearch\" value=\"\">\r\n\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        F/A Home Search\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td class=\"formInstruct\" colspan=\"4\">\r\n        Enter Search Criteria below to find an F/A Home. If a Resource ID is entered, the search will use only that identification number to find a match.\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Home Name");
          _jspx_th_impact_validateInput_4.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_4.setName("txtSzNmResource");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setRequired("false");
          _jspx_th_impact_validateInput_4.setValue( FormattingHelper.formatString( szNmResource ) );
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("Resource ID");
          _jspx_th_impact_validateInput_5.setConstraint("ID");
          _jspx_th_impact_validateInput_5.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_5.setName("txtUlIdResource");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setValue(ulIdResource);
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzCdRsrcFaHomeStatus");
          _jspx_th_impact_validateSelect_0.setLabel("Status");
          _jspx_th_impact_validateSelect_0.setRequired("false");
          _jspx_th_impact_validateSelect_0.setCodesTable("CFAHMSTA");
          _jspx_th_impact_validateSelect_0.setValue(szCdRsrcFaHomeStatus);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
          out.write("\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selSzCdRsrcRegion");
          _jspx_th_impact_validateSelect_1.setLabel("Region");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setCodesTable("CREGIONS");
          _jspx_th_impact_validateSelect_1.setValue(szCdRsrcRegion);
          _jspx_th_impact_validateSelect_1.setExcludeOptions( exOptions );
          _jspx_th_impact_validateSelect_1.setOnChange("populateCounty(false)");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selSzCdRsrcCnty");
          _jspx_th_impact_validateSelect_2.setLabel("County");
          _jspx_th_impact_validateSelect_2.setRequired("false");
          _jspx_th_impact_validateSelect_2.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_2.setValue(szCdRsrcCnty);
          _jspx_th_impact_validateSelect_2.setStyle("width: 150px");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("selSzCdRsrcCategory");
          _jspx_th_impact_validateSelect_3.setLabel("Category");
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setCodesTable("CFACATEG");
          _jspx_th_impact_validateSelect_3.setValue(szCdRsrcCategory);
          _jspx_th_impact_validateSelect_3.setOnChange("setHomeTypeDisable();");
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("City");
          _jspx_th_impact_validateInput_6.setConstraint("City");
          _jspx_th_impact_validateInput_6.setRequired("false");
          _jspx_th_impact_validateInput_6.setName("txtSzAddrRsrcAddrCity");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setValue(szAddrRsrcAddrCity);
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setName("selCCdRsrcFaHomeType1");
          _jspx_th_impact_validateSelect_4.setLabel("Home Type");
          _jspx_th_impact_validateSelect_4.setRequired("false");
          _jspx_th_impact_validateSelect_4.setCodesTable("CFAHMTYP");
          _jspx_th_impact_validateSelect_4.setValue(cCdRsrcFaHomeType1);
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setName("selSzCdRsrcLanguage");
          _jspx_th_impact_validateSelect_5.setLabel("Language");
          _jspx_th_impact_validateSelect_5.setCodesTable("CLANG");
          _jspx_th_impact_validateSelect_5.setValue(szCdRsrcLanguage);
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setName("selSzCdSchoolDistrict");
          _jspx_th_impact_validateSelect_6.setLabel("School District");
          _jspx_th_impact_validateSelect_6.setRequired("false");
          _jspx_th_impact_validateSelect_6.setCodesTable("CSCHDSTR");
          _jspx_th_impact_validateSelect_6.setValue(szCdSchoolDistrict);
          _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setName("selSzCdMaritalStatus");
          _jspx_th_impact_validateSelect_7.setLabel("Marital Status");
          _jspx_th_impact_validateSelect_7.setExcludeOptions( excludeFAMSTRC );
          _jspx_th_impact_validateSelect_7.setCodesTable("CFAMSTRC");
          _jspx_th_impact_validateSelect_7.setValue( szCdMaritalStatus );
          _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtDtInquiryDate");
          _jspx_th_impact_validateDate_0.setLabel("Inquiry Date");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue("");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  ");
          out.write("\r\n  </table>\r\n\r\n  <br>\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("AdvanceFAHomeSearch");
          _jspx_th_impact_ExpandableSectionTag_0.setId("lbAdvanceFAHomeSearch_Id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Advanced Search");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n     \r\n         <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" border=\"0\">\r\n\r\n      <tr>\r\n        <th colspan=\"6\">\r\n          Child Search\r\n        </th>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n       <td colspan= class=\"subDetail\">\r\n       ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_7.setType("text");
              _jspx_th_impact_validateInput_7.setLabel("Child Person Id");
              _jspx_th_impact_validateInput_7.setConstraint("Digit10Less");
              _jspx_th_impact_validateInput_7.setRequired("false");
              _jspx_th_impact_validateInput_7.setName("txtNbrChildPersonId");
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              _jspx_th_impact_validateInput_7.setValue(nbrChildPersonId);
              _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_7.setSize("10");
              _jspx_th_impact_validateInput_7.setMaxLength("10");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n       <td colspan=\"2\" class=\"alignRight\">\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_0.setName("btnChildLookUp");
              _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
              _jspx_th_impact_ButtonTag_0.setForm(formName);
              _jspx_th_impact_ButtonTag_0.setAction("/fad/FAHomeSearch/childLookup");
              _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td > \r\n      <td colspan=\"2\">\r\n        </td>\r\n      </tr>\r\n\t ");
 if(szChildName != null && szChildName != ""){  
              out.write("\r\n      <tr class=\"subDetail\">\r\n\t<td>\r\n\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Child Name");
              _jspx_th_impact_validateDisplayOnlyField_0.setName("txtSzNmChildName");
              _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatString( szChildName ) );
              int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n\t  <td>\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Age");
              _jspx_th_impact_validateDisplayOnlyField_1.setName("txtSzNmChildAge");
              _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatString( nbrChildAge) );
              int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n\t  <td>\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_2.setLabel("DOB");
              _jspx_th_impact_validateDisplayOnlyField_2.setName("txtSzNmChildDob");
              _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatString( dtChildDob ) );
              int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      </tr>\r\n\t  ");
} 
              out.write("\r\n    </table>\r\n\t\t\r\n\t\t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n           <tr>\r\n\t\t   <th colspan=\"2\" id=\"childCharacteristics\">Child Characteristics</th>\r\n\t\t        <td align=\"right\">\r\n     <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:expandAllCategories()\">Expand All</a>&nbsp;\r\n     <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:collapseAllCategories()\">Collapse All</a>&nbsp;\r\n     </td>\r\n\t\t   </tr>\r\n\t\t   </table>\r\n\t\t  \r\n\t\t  \r\n          ");

        List<CodeAttributes> characteristicsCategories = Lookup.getCategoryCollection(CodesTables.CCHRTCA2);
		Iterator characteristicsCategoryIterator = characteristicsCategories.iterator();
		//characteristicsCategoryIterator.sortDecode();
		// STGAP00017304: to not display 'None (non-special needs)' on the Other section
		List excludeCodesChildChar = new ArrayList<String>();
		
        while(characteristicsCategoryIterator.hasNext()){
        	CodeAttributes charCatCodeAtt = (CodeAttributes)characteristicsCategoryIterator.next();
            String catCode = charCatCodeAtt.getCode();
			String cbxName = "CharCbx" + catCode;
            String catDecode = charCatCodeAtt.getDecode();
			Boolean isExpanded = false;
			int catCodeSize =  Lookup.getCategoryCollection(catCode).size();
			// STGAP00017304: populate exlcude codes for Other section only
			if (CodesTables.OTH2.equals(catCode)) {
			  excludeCodesChildChar.add(CodesTables.OTH2_00); 
			}			
			List<String> validDefault = new ArrayList<String>();
		    if (checkedValues != null && !checkedValues.isEmpty()) {
              for (Iterator<String> it = checkedValues.iterator(); it.hasNext();) {
                String evalString = (String) it.next();
                String validCode =Lookup.simpleDecodeSafe(catCode,evalString );
                if(!"".equals(validCode)){ 
                  isExpanded = true;
                  validDefault.add(evalString);
                }
		      }
			}
			
			
        
              out.write("\r\n        \t\t");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ExpandableSectionTag_1.setName( catCode );
              _jspx_th_impact_ExpandableSectionTag_1.setIsExpanded( isExpanded );
              _jspx_th_impact_ExpandableSectionTag_1.setId("");
              _jspx_th_impact_ExpandableSectionTag_1.setLabel( catDecode );
              _jspx_th_impact_ExpandableSectionTag_1.setAnchor( cbxName );
              _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n\t\t");
  

		String onClickSelectAll = "javascript:setIsDirtyCalled(true); selectAll(" + "'" + catCode + "'" 
							    															+ "," 
							    															+ catCodeSize 
							    															+ "," 
							    															+ "true" 
							    															+ ");";
																							
																							
		
																		
		String onClickDeSelectAll = "javascript:setIsDirtyCalled(true); selectAll(" + "'" + catCode + "'" 
							    															+ "," 
							    															+ catCodeSize 
							    															+ "," 
							    															+ "false" 
							    															+ ");";

                  out.write("\r\n\r\n\t\t \t\t\t<tr>\r\n\t\t \t\t\t\r\n\t\t    <td><a href=\"");
                  out.print( onClickSelectAll );
                  out.write("\" tabIndex=\"");
                  out.print(tabIndex++);
                  out.write("\" onClick=\"hrefDirtyBypass=true;\"> Select All Child Characteristics</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a  href=\"");
                  out.print( onClickDeSelectAll );
                  out.write("\" tabIndex=\"");
                  out.print(tabIndex++);
                  out.write("\" onClick=\"hrefDirtyBypass=true;\">Deselect All Child Characteristics</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t  <td colspan=\"2\" class=\"subDetail\">\r\n\t\t\t\t\t\t");
                  //  impact:codesCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
                  _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
                  _jspx_th_impact_codesCheckbox_0.setDefaultCodes( validDefault != null ? validDefault :  checkedValues );
                  _jspx_th_impact_codesCheckbox_0.setName( cbxName );
                  _jspx_th_impact_codesCheckbox_0.setCodesTableName( catCode );
                  _jspx_th_impact_codesCheckbox_0.setOrderBy("decode");
                  _jspx_th_impact_codesCheckbox_0.setColumns(3);
                  _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
                  _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
                  _jspx_th_impact_codesCheckbox_0.setExcludeCodes(excludeCodesChildChar );
                  int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
                  if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t</td>         \r\n           </tr>\r\n          </table>\r\n\t\t");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t");

		}
		
              out.write("\r\n          \r\n\r\n    <br>\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE5\">\r\n  \t\t<tr>\r\n        \t<th colspan=\"4\">Child Race</th>\r\n  \t\t</tr>\r\n\t  \t<tr class=\"subDetail\">\r\n\t  \t\t <td>\r\n\t\t      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_1.setName("cbxRace");
              _jspx_th_impact_codesCheckbox_1.setDefaultCodes(szCdRace);
              _jspx_th_impact_codesCheckbox_1.setCodesTableName(CodesTables.CADRACE);
              _jspx_th_impact_codesCheckbox_1.setColumns(2);
              _jspx_th_impact_codesCheckbox_1.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_1.setDisabled("false");
              int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
              if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t   \t</td>\r\n  \t\t</tr>\r\n\t</table>\r\n\t\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE6\">\r\n  \t\t<tr>\r\n        \t<th colspan=\"4\">Child Ethnicity</th>\r\n  \t\t</tr>\r\n  \t\t<tr class=\"subDetail\">\r\n\t  \t\t <td>\r\n\t\t      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_2.setName("cbxEth");
              _jspx_th_impact_codesCheckbox_2.setDefaultCodes(szCdEthnicity);
              _jspx_th_impact_codesCheckbox_2.setCodesTableName(CodesTables.CINDETHN);
              _jspx_th_impact_codesCheckbox_2.setColumns(3);
              _jspx_th_impact_codesCheckbox_2.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_2.setDisabled("false");
              int _jspx_eval_impact_codesCheckbox_2 = _jspx_th_impact_codesCheckbox_2.doStartTag();
              if (_jspx_th_impact_codesCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t   \t</td>\r\n  \t\t</tr>\r\n\t</table>\r\n\t<br>\r\n    <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" border=\"0\">\r\n      <tr>\r\n        <th colspan=\"4\">\r\n          Child Demographics\r\n        </th>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_8.setName("selCCdPersonSex");
              _jspx_th_impact_validateSelect_8.setLabel("Gender");
              _jspx_th_impact_validateSelect_8.setCodesTable("CSEX");
              _jspx_th_impact_validateSelect_8.setExcludeOptions( excludeGender );
              _jspx_th_impact_validateSelect_8.setValue(cCdPersonSex);
              _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td></td>\r\n        <td></td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_9.setName("selCdReligion");
              _jspx_th_impact_validateSelect_9.setLabel("Religion");
              _jspx_th_impact_validateSelect_9.setCodesTable("CRELIGNS");
              _jspx_th_impact_validateSelect_9.setValue(szCdReligion);
              _jspx_th_impact_validateSelect_9.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_8.setType("text");
              _jspx_th_impact_validateInput_8.setLabel("Capacity");
              _jspx_th_impact_validateInput_8.setConstraint("Numeric");
              _jspx_th_impact_validateInput_8.setRequired("false");
              _jspx_th_impact_validateInput_8.setName("txtNbrRsrcFacilCapacity");
              _jspx_th_impact_validateInput_8.setCssClass("formInput");
              _jspx_th_impact_validateInput_8.setValue(nbrRsrcFacilCapacity);
              _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_8.setSize("5");
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_9.setType("text");
              _jspx_th_impact_validateInput_9.setLabel("Current Placements");
              _jspx_th_impact_validateInput_9.setConstraint("Numeric");
              _jspx_th_impact_validateInput_9.setRequired("false");
              _jspx_th_impact_validateInput_9.setName("txtNbrRsrcFacilCurrPlcmnt");
              _jspx_th_impact_validateInput_9.setCssClass("formInput");
              _jspx_th_impact_validateInput_9.setValue(nbrRsrcFacilCurrPlcmnts);
              _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_9.setSize("5");
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_10.setType("text");
              _jspx_th_impact_validateInput_10.setLabel("Open Slots");
              _jspx_th_impact_validateInput_10.setConstraint("Numeric");
              _jspx_th_impact_validateInput_10.setRequired("false");
              _jspx_th_impact_validateInput_10.setName("txtNbrRsrcFacilOpenSlots");
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              _jspx_th_impact_validateInput_10.setValue(nbrRsrcFacilOpenSlots);
              _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_10.setSize("5");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>      \r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_10.setName("cbxMinYear");
              _jspx_th_impact_validateSelect_10.setLabel("Min Year");
              _jspx_th_impact_validateSelect_10.setOptions(yearOptions);
              _jspx_th_impact_validateSelect_10.setValue(sMinYear);
              _jspx_th_impact_validateSelect_10.setBlankValue("true");
              _jspx_th_impact_validateSelect_10.setDisabled("false");
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_11.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_11.setName("cbxMinMonth");
              _jspx_th_impact_validateSelect_11.setLabel("Min Month");
              _jspx_th_impact_validateSelect_11.setOptions(monthOptions);
              _jspx_th_impact_validateSelect_11.setValue(sMinMonth);
              _jspx_th_impact_validateSelect_11.setBlankValue("true");
              _jspx_th_impact_validateSelect_11.setDisabled("false");
              int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
              if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_12.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_12.setName("cbxMaxYear");
              _jspx_th_impact_validateSelect_12.setLabel("Max Year");
              _jspx_th_impact_validateSelect_12.setOptions(yearOptions);
              _jspx_th_impact_validateSelect_12.setValue(sMaxYear);
              _jspx_th_impact_validateSelect_12.setBlankValue("true");
              _jspx_th_impact_validateSelect_12.setDisabled("false");
              int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
              if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_13.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_13.setName("cbxMaxMonth");
              _jspx_th_impact_validateSelect_13.setLabel("Max Month");
              _jspx_th_impact_validateSelect_13.setOptions(monthOptions);
              _jspx_th_impact_validateSelect_13.setValue(sMaxMonth);
              _jspx_th_impact_validateSelect_13.setBlankValue("true");
              _jspx_th_impact_validateSelect_13.setDisabled("false");
              int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
              if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSearch");
          _jspx_th_impact_ButtonTag_1.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_1.setFunction("return onSearchClick('S')");
          _jspx_th_impact_ButtonTag_1.setForm(formName);
          _jspx_th_impact_ButtonTag_1.setAction("/fad/FAHomeSearch/faHomeSearch");
          _jspx_th_impact_ButtonTag_1.setBackSafe("false");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<br />\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmFAHomeResult");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/fad/FAHomeSearch/faHomeSearch");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          out.write("\r\n  ");
PaginationResultBean pPaginationResultBean = (PaginationResultBean) request
                                                                                 .getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);
      if (pPaginationResultBean != null) {
        DatabaseResultDetails db = pPaginationResultBean.getResultDetails();
      }
      
     Boolean childSearchBtnPressed = (Boolean) state.getAttribute("childSearchBtnPressed" , request) != null ? (Boolean) state.getAttribute("childSearchBtnPressed" , request) : false;
     state.removeAttribute("childSearchBtnPressed" , request);
     String prevUrl = ContextHelper.getPreviousUrl(request);
     // STGAP00017310: update the pool of all possible prev url with the new entry: child lookup
      if (!FormValidation.pageHasErrorMessages(request)
          && !FormValidation.pageHasValidationMessages("frmFAHomeResult", request) && !childSearchBtnPressed) {
        if (FAHomeSearchConversation.SEARCH_PAGE.equals(prevUrl)
            || FAHomeSearchConversation.DISPLAY_SEARCH_PAGE.equals(prevUrl)
            || FAHomeSearchConversation.CHILD_SEARCH_PAGE.equals(prevUrl)) {

          
          out.write("\r\n\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSubmitUrl("/fad/FAHomeSearch/faHomeSearch");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n    <div class=\"alignRight\">\r\n      <div class=\"formInstruct\">\r\n        Scroll for more information -->\r\n      </div>\r\n    </div>\r\n    <div id=\"faHomSearchResults\" style=\"height:200px; width:765px; overflow:auto\" class=\"tableborderList\">\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"1000\">\r\n        <tr class=\"thList\">\r\n          <td class=\"thList\">\r\n            Resource Name\r\n          </td>\r\n          <td class=\"thList\">\r\n            Category\r\n          </td>\r\n          <td class=\"thList\">\r\n            Status\r\n          </td>\r\n          <td class=\"thList\">\r\n            Dispstn\r\n          </td>\r\n          <td class=\"thList\">\r\n            Report ID\r\n          </td>\r\n          <td class=\"thList\">\r\n            Non-DFCS\r\n          </td>\r\n          ");
              out.write("\r\n          <td class=\"thList\">\r\n            City\r\n          </td>\r\n          <td class=\"thList\">\r\n            Worker Name\r\n          </td>\r\n          <td class=\"thList\">\r\n            Worker Phone\r\n          </td>\r\n          <td class=\"thList\">\r\n            Ext\r\n          </td>\r\n        </tr>\r\n        ");

           FAHomeValueBean homeRow = null;
           int iLoopCounter = 0;
           //SIR 23114 - added .isEmpty()
           if (faHomeList == null || faHomeList.isEmpty()) {
         
              out.write("\r\n        <tr class=\"tableBG\">\r\n          <td colspan=\"9\" class=\"subDetail\">\r\n            ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");
} else if (faHomeList != null) {
            for (iLoopCounter = 0; iLoopCounter < faHomeList.size(); iLoopCounter++) {
              homeRow = (FAHomeValueBean) faHomeList.get(iLoopCounter);

              
              out.write("\r\n        <tr class=\"");
              out.print( FormattingHelper.getRowCss( iLoopCounter + 1 ) );
              out.write("\">\r\n          ");
              out.write("\r\n          <td>\r\n            <a href=\"javascript:submitFormToHomeDetail( '");
              out.print(iLoopCounter);
              out.write("','M')\">");
              out.print(homeRow.getResourceName());
              out.write(" </a>\r\n          </td>\r\n          <td>\r\n            ");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFACATEG, homeRow.getResourceCategory()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, homeRow.getFaHomeStatus()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(StringHelper.getNonNullString(homeRow.getCdDispstn()));
              out.write("\r\n          </td>\r\n          <td>\r\n            <a href=\"javascript:submitStage_ID('");
              out.print(homeRow.getUlIdStage());
              out.write("')\" tabIndex=\"");
              out.print(tabIndex++);
              out.write('"');
              out.write('>');
              out.print(FormattingHelper.formatInt(homeRow.getUlIdStage()));
              out.write("</a>\r\n          </td>\r\n          <td>\r\n            ");
              out.print(StringHelper.getNonNullString(homeRow.getIndRsrcNonPrs()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(homeRow.getCity());
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(homeRow.getPeronFullName());
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print((homeRow.getPhoneNumber() != null) ? FormattingHelper
                                                                                  .formatPhone(homeRow.getPhoneNumber())
                                                               : "");
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print((homeRow.getPhoneExtensionNumber() != null) ? homeRow.getPhoneExtensionNumber() : "");
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");
}
          }

          
              out.write("\r\n      </table>\r\n    </div>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n  ");
if (bAddButton) {

            
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_2.setName("btnAdd");
          _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_2.setFunction("submitFormForNewHome('A')");
          _jspx_th_impact_ButtonTag_2.setForm("frmFAHomeResult");
          _jspx_th_impact_ButtonTag_2.setAction("/fad/FAHomeSearch/displayNewHomeInformation");
          _jspx_th_impact_ButtonTag_2.setBackSafe("false");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
}
        }
      }

    
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  populateCounty(true);\r\n</script>\r\n\r\n");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CCOUNT");
    _jspx_th_impact_codeArray_0.setArrayName("CCOUNT");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CCOUNT01");
    _jspx_th_impact_codeArray_1.setArrayName("CCOUNT01");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_2.setParent(null);
    _jspx_th_impact_codeArray_2.setCodeName("CCOUNT02");
    _jspx_th_impact_codeArray_2.setArrayName("CCOUNT02");
    _jspx_th_impact_codeArray_2.setBlankValue("true");
    int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
    if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_3.setParent(null);
    _jspx_th_impact_codeArray_3.setCodeName("CCOUNT03");
    _jspx_th_impact_codeArray_3.setArrayName("CCOUNT03");
    _jspx_th_impact_codeArray_3.setBlankValue("true");
    int _jspx_eval_impact_codeArray_3 = _jspx_th_impact_codeArray_3.doStartTag();
    if (_jspx_th_impact_codeArray_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_4.setParent(null);
    _jspx_th_impact_codeArray_4.setCodeName("CCOUNT04");
    _jspx_th_impact_codeArray_4.setArrayName("CCOUNT04");
    _jspx_th_impact_codeArray_4.setBlankValue("true");
    int _jspx_eval_impact_codeArray_4 = _jspx_th_impact_codeArray_4.doStartTag();
    if (_jspx_th_impact_codeArray_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_5.setParent(null);
    _jspx_th_impact_codeArray_5.setCodeName("CCOUNT05");
    _jspx_th_impact_codeArray_5.setArrayName("CCOUNT05");
    _jspx_th_impact_codeArray_5.setBlankValue("true");
    int _jspx_eval_impact_codeArray_5 = _jspx_th_impact_codeArray_5.doStartTag();
    if (_jspx_th_impact_codeArray_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_6.setParent(null);
    _jspx_th_impact_codeArray_6.setCodeName("CCOUNT06");
    _jspx_th_impact_codeArray_6.setArrayName("CCOUNT06");
    _jspx_th_impact_codeArray_6.setBlankValue("true");
    int _jspx_eval_impact_codeArray_6 = _jspx_th_impact_codeArray_6.doStartTag();
    if (_jspx_th_impact_codeArray_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_7.setParent(null);
    _jspx_th_impact_codeArray_7.setCodeName("CCOUNT07");
    _jspx_th_impact_codeArray_7.setArrayName("CCOUNT07");
    _jspx_th_impact_codeArray_7.setBlankValue("true");
    int _jspx_eval_impact_codeArray_7 = _jspx_th_impact_codeArray_7.doStartTag();
    if (_jspx_th_impact_codeArray_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_8.setParent(null);
    _jspx_th_impact_codeArray_8.setCodeName("CCOUNT08");
    _jspx_th_impact_codeArray_8.setArrayName("CCOUNT08");
    _jspx_th_impact_codeArray_8.setBlankValue("true");
    int _jspx_eval_impact_codeArray_8 = _jspx_th_impact_codeArray_8.doStartTag();
    if (_jspx_th_impact_codeArray_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_9.setParent(null);
    _jspx_th_impact_codeArray_9.setCodeName("CCOUNT09");
    _jspx_th_impact_codeArray_9.setArrayName("CCOUNT09");
    _jspx_th_impact_codeArray_9.setBlankValue("true");
    int _jspx_eval_impact_codeArray_9 = _jspx_th_impact_codeArray_9.doStartTag();
    if (_jspx_th_impact_codeArray_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_10.setParent(null);
    _jspx_th_impact_codeArray_10.setCodeName("CCOUNT10");
    _jspx_th_impact_codeArray_10.setArrayName("CCOUNT10");
    _jspx_th_impact_codeArray_10.setBlankValue("true");
    int _jspx_eval_impact_codeArray_10 = _jspx_th_impact_codeArray_10.doStartTag();
    if (_jspx_th_impact_codeArray_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_11.setParent(null);
    _jspx_th_impact_codeArray_11.setCodeName("CCOUNT11");
    _jspx_th_impact_codeArray_11.setArrayName("CCOUNT11");
    _jspx_th_impact_codeArray_11.setBlankValue("true");
    int _jspx_eval_impact_codeArray_11 = _jspx_th_impact_codeArray_11.doStartTag();
    if (_jspx_th_impact_codeArray_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_12.setParent(null);
    _jspx_th_impact_codeArray_12.setCodeName("CCOUNT12");
    _jspx_th_impact_codeArray_12.setArrayName("CCOUNT12");
    _jspx_th_impact_codeArray_12.setBlankValue("true");
    int _jspx_eval_impact_codeArray_12 = _jspx_th_impact_codeArray_12.doStartTag();
    if (_jspx_th_impact_codeArray_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_13.setParent(null);
    _jspx_th_impact_codeArray_13.setCodeName("CCOUNT13");
    _jspx_th_impact_codeArray_13.setArrayName("CCOUNT13");
    _jspx_th_impact_codeArray_13.setBlankValue("true");
    int _jspx_eval_impact_codeArray_13 = _jspx_th_impact_codeArray_13.doStartTag();
    if (_jspx_th_impact_codeArray_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_14.setParent(null);
    _jspx_th_impact_codeArray_14.setCodeName("CCOUNT14");
    _jspx_th_impact_codeArray_14.setArrayName("CCOUNT14");
    _jspx_th_impact_codeArray_14.setBlankValue("true");
    int _jspx_eval_impact_codeArray_14 = _jspx_th_impact_codeArray_14.doStartTag();
    if (_jspx_th_impact_codeArray_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_15.setParent(null);
    _jspx_th_impact_codeArray_15.setCodeName("CCOUNT15");
    _jspx_th_impact_codeArray_15.setArrayName("CCOUNT15");
    _jspx_th_impact_codeArray_15.setBlankValue("true");
    int _jspx_eval_impact_codeArray_15 = _jspx_th_impact_codeArray_15.doStartTag();
    if (_jspx_th_impact_codeArray_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_16.setParent(null);
    _jspx_th_impact_codeArray_16.setCodeName("CCOUNT");
    _jspx_th_impact_codeArray_16.setArrayName("CCOUNT98");
    _jspx_th_impact_codeArray_16.setBlankValue("true");
    int _jspx_eval_impact_codeArray_16 = _jspx_th_impact_codeArray_16.doStartTag();
    if (_jspx_th_impact_codeArray_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("minAge");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("maxAge");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("cReqFuncCd");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
