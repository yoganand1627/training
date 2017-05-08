<%--
  FAHomeSearch.jsp
  Created by:  Habib H
  12/09/02

  Change History:
  Date        User              Description
  --------   ----------------   --------------------------------------------------
  07/08/2003  Todd Reser        SIR 18729 - Added CCOUNT codeArrays,
                                populateCounty() function and calls to it when the
                                Region is changed and when the page loads.
  07/23/2003  Eric Dickman      SIR 19048 -- Added the onClick to the href.
  09/17/2003  Jonathan Hardy    SIR 17004 - If the page is loading with search results,
                                the county shouldn't be cleared by populateCounty.
  08/30/2004  gerryc            SIR 23114 - took out the defaultButton="true"
                                parameter from the frmFAHomeResult form.  When
                                entering a specific page number to jump to, and
                                hitting enter, the default button was getting used
                                so the user was taken to the Add Home page.  Fixed
                                some spacing between forms.
  11/01/2006  aodutayo          SHINES release 2 changes. Added school district, marital status
                                inquiry date to the upper section of the page - F/A Home Search;
                                for the lower section - subsection title changed - "Child Demographics"
                                replaced "Age Range"; current placement and capacity text fields were
                                added.
  10/27/2008 mchillman          STGAP00010728  Altered code to support new race and ethnic display
  04/22/2009 hjbaptiste         STGAP00012943: Decode the Category column
  11/12/2010 schoi		  		SMS #81140: MR-074 Filter Marital Status dropdown to exclude 'Unmarried Couple'
  10/25/1011 htvo               [update for Courtney] ECEM 5.0: changing search by child characteristics
  10/25/2011 htvo               STGAP00017310: added childLookup url to the pool of all possible prev url. 
  11/02/2011 htvo               STGAP00017304: to not display 'None (non-special needs)' on the Other section
  11/10/2011 schoi              STGAP00017405: ECEM 5.0 Updated constraint from ID to Digit10Less per updated Design
  04/11/2012 vcollooru 			STGAP00018067: Modified to remove the codeArray tag referring to regions 16 and 17
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>

<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.Collections" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.SortedMap"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fad.FAHomeValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fad.FAHomeSearchConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="org.exolab.castor.types.Date"%>

<%//  Declare variables
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
	 
	   
	  
%>

<script type="text/javascript" language="JavaScript1.2">
function onSearchClick(buttonClicked)
{

  enableValidation("<%= formName %>");
  var minAgeYear = 0;
  var minAgeMonth = 0;
  var maxAgeYear = 0;
  var maxAgeMonth = 0;
  var selRsrcStatus = <%=formName%>.selSzCdRsrcFaHomeStatus.value;
  // ECEM 5.0 checking for Approved (Full) - Active and Approved (Special) - Active
   if ( selRsrcStatus == "ASA" || selRsrcStatus == "AFA" )
   {
   var bRetValue = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_RVW_CHARS) %>');
   if(!bRetValue){
   return false;
   }else{
   
   }
   
   }

  
  minAgeYear = (<%=formName%>.cbxMinYear.value != "" ) ? <%=formName%>.cbxMinYear.value : minAgeYear;
  minAgeMonth = (<%=formName%>.cbxMinMonth.value != "" ) ? <%=formName%>.cbxMinMonth.value : minAgeMonth;
  maxAgeYear = (<%=formName%>.cbxMaxYear.value != "" ) ? <%=formName%>.cbxMaxYear.value : maxAgeYear;
  maxAgeMonth = (<%=formName%>.cbxMaxMonth.value != "") ? <%=formName%>.cbxMaxMonth.value : maxAgeMonth;

  <%=formName%>.minAge.value = minAgeYear * 12 + parseInt(minAgeMonth);
  <%=formName%>.maxAge.value = maxAgeYear * 12 + parseInt(maxAgeMonth);
  
  
  
  

  if ( buttonClicked == 'S') {
    <%=formName%>.cReqFuncCd.value = 'S';
  } else {
    <%=formName%>.cReqFuncCd.value = null;
  }
  return true;
}

 function selectAll(catCode, numOfCheckboxes, checkValue) {
  for ( i = 1; i <= numOfCheckboxes; i++ )
  {

    checkboxField = eval("frmFaHomeSearch.CharCbx" + catCode + i);	
 if (checkValue && checkboxField.checked != checkValue) {
	checkboxField.click();
	}else if (checkboxField.checked != checkValue) {
	checkboxField.click();
	}
	
}
		}
		
		
		function expandAllCategories()
{
expandCollapsed('expandedDED2','collapsedDED2' )
expandCollapsed('expandedEBD2','collapsedEBD2' )
expandCollapsed('expandedEXB2','collapsedEXB2' )
expandCollapsed('expandedFHI2','collapsedFHI2' )
expandCollapsed('expandedHVI2','collapsedHVI2' )
expandCollapsed('expandedMED2','collapsedMED2' )
expandCollapsed('expandedMER2','collapsedMER2' )
expandCollapsed('expandedOTH2','collapsedOTH2' )

}


function collapseAllCategories()
{
expandCollapsed('collapsedDED2','expandedDED2' )
expandCollapsed('collapsedEBD2','expandedEBD2' )
expandCollapsed('collapsedEXB2','expandedEXB2' )
expandCollapsed('collapsedFHI2','expandedFHI2' )
expandCollapsed('collapsedHVI2','expandedHVI2' )
expandCollapsed('collapsedMED2','expandedMED2' )
expandCollapsed('collapsedMER2','expandedMER2' )
expandCollapsed('collapsedOTH2','expandedOTH2' )

}


/*
*This function submits the form to bring up Home Info page for a new home.
*/

function submitFormForNewHome(cReqFuncCd)
{
  <%= formName %>.cReqFuncCd.value = cReqFuncCd;
  return true;
}

/*
*This function submits the form to bring up Home Info detail page.
*/
function submitFormToHomeDetail( indexNum, cReqFuncCd)
{
  <%= formName %>.indexNum.value = indexNum;
  <%= formName %>.cReqFuncCd.value = cReqFuncCd;
  submitValidateForm( "<%= formName %>", "/fad/FAHomeSearch/displayHomeInformationDetail" );
}


function submitStage_ID(stageId)
{
  <%= formName %>.stageId.value = stageId;
   // document.frmCallLog.personId.value = personId;
    <%= formName %>.displayIntakeActionsFAHomeSearch.value = "<%=ArchitectureConstants.Y%>";
  <%= formName %>.intakeActionsPageMode.value = "<%=PageModeConstants.VIEW%>";
  submitValidateForm("<%= formName %>", "/intake/IntakeActions/displayIntakeActions");
}


function setHomeTypeDisable()
{
  if( <%=formName%>.selSzCdRsrcCategory.value == '<%=FAHomeValueBean.Adoptive%>' ) {
    <%=formName%>.selCCdRsrcFaHomeType1.value = "";
    <%=formName%>.selCCdRsrcFaHomeType1.disabled = true;
  } else {
    <%=formName%>.selCCdRsrcFaHomeType1.disabled = false;
  }

}

function setRegAdptExchng( itemSelected )
{
   <%=formName%>.rbIndRegAdptnExchge.value = itemSelected;
   <%=formName%>.hdnIndRegAdptnExchge.value = itemSelected;
}

<%-- SIR 18729 - Added codeArrays and populateCounty function --%>
  //Get county code/decode array with all data
  <impact:codeArray codeName="CCOUNT" arrayName="CCOUNT" blankValue="true"/>
  //Get county code/decode array filtered for region 01
  <impact:codeArray codeName="CCOUNT01" arrayName="CCOUNT01" blankValue="true"/>
  //Get county code/decode array filtered for region 02
  <impact:codeArray codeName="CCOUNT02" arrayName="CCOUNT02" blankValue="true"/>
  //Get county code/decode array filtered for region 03
  <impact:codeArray codeName="CCOUNT03" arrayName="CCOUNT03" blankValue="true"/>  
  //Get county code/decode array filtered for region 04
  <impact:codeArray codeName="CCOUNT04" arrayName="CCOUNT04" blankValue="true"/>
  //Get county code/decode array filtered for region 05
  <impact:codeArray codeName="CCOUNT05" arrayName="CCOUNT05" blankValue="true"/>
  //Get county code/decode array filtered for region 06
  <impact:codeArray codeName="CCOUNT06" arrayName="CCOUNT06" blankValue="true"/>
  //Get county code/decode array filtered for region 07
  <impact:codeArray codeName="CCOUNT07" arrayName="CCOUNT07" blankValue="true"/>
  //Get county code/decode array filtered for region 08
  <impact:codeArray codeName="CCOUNT08" arrayName="CCOUNT08" blankValue="true"/>
  //Get county code/decode array filtered for region 09
  <impact:codeArray codeName="CCOUNT09" arrayName="CCOUNT09" blankValue="true"/>
  //Get county code/decode array filtered for region 10
  <impact:codeArray codeName="CCOUNT10" arrayName="CCOUNT10" blankValue="true"/>
  //Get county code/decode array filtered for region 11
  <impact:codeArray codeName="CCOUNT11" arrayName="CCOUNT11" blankValue="true"/>
  //Get county code/decode array filtered for region 12
  <impact:codeArray codeName="CCOUNT12" arrayName="CCOUNT12" blankValue="true"/>
  //Get county code/decode array filtered for region 13
  <impact:codeArray codeName="CCOUNT13" arrayName="CCOUNT13" blankValue="true"/>
  //Get county code/decode array filtered for region 14
  <impact:codeArray codeName="CCOUNT14" arrayName="CCOUNT14" blankValue="true"/>
  //Get county code/decode array filtered for region 15
  <impact:codeArray codeName="CCOUNT15" arrayName="CCOUNT15" blankValue="true"/>
  //Get county code/decode array filtered for region 98
  <impact:codeArray codeName="CCOUNT" arrayName="CCOUNT98" blankValue="true"/>

function populateCounty(onPageLoad)
{
  if ( <%=formName%>.selSzCdRsrcRegion.value == <%= CodesTables.CCOUNT_099 %> ||
       <%=formName%>.selSzCdRsrcRegion.value == "") {
    clearDropdown ( <%=formName%>.selSzCdRsrcCnty );
  } else {
    var dropdownValue = "";
    if (onPageLoad && <%= FAHomeSearchConversation.SEARCH_PAGE.equals(ContextHelper.getPreviousUrl(request)) ||
                          FAHomeSearchConversation.DISPLAY_SEARCH_PAGE.equals(ContextHelper.getPreviousUrl(request))  %>) {
      <% String dropdown = szCdRsrcCnty==null?request.getParameter("selSzCdRsrcCnty"):szCdRsrcCnty; %>
      dropdownValue = "<%=dropdown%>";
    }
    populateDropdown(<%=formName%>.selSzCdRsrcCnty, dropdownValue, eval("CCOUNT"+<%=formName%>.selSzCdRsrcRegion.value) );
  }
}

</script>

<impact:validateErrors />
<impact:validateForm name="<%=formName%>" method="post" action="/fad/FAHomeSearch/faHomeSearch" validationClass="gov.georgia.dhr.dfcs.sacwis.web.fad.FAHomeSearchCustomValidation" pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

  <impact:validateInput type="hidden" name="minAge" />
  <impact:validateInput type="hidden" name="maxAge" />
  <impact:validateInput type="hidden" name="cReqFuncCd" />
  <impact:validateInput type="hidden" name="indexNum" editableMode="<%=EditableMode.EDIT%>" />
  <input type="hidden" name="stageId" value="">
  <input type="hidden" name="intakeActionsPageMode" value="">
  <input type="hidden" name="displayIntakeActionsFAHomeSearch" value="">


  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="4">
        F/A Home Search
      </th>
    </tr>
    <tr>
      <td class="formInstruct" colspan="4">
        Enter Search Criteria below to find an F/A Home. If a Resource ID is entered, the search will use only that identification number to find a match.
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" label="Home Name" conditionallyRequired="true" name="txtSzNmResource" cssClass="formInput" required="false" value="<%= FormattingHelper.formatString( szNmResource ) %>" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:validateInput type="text" label="Resource ID" constraint="ID" conditionallyRequired="true" name="txtUlIdResource" cssClass="formInput" value="<%=ulIdResource%>" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selSzCdRsrcFaHomeStatus" label="Status" required="false" codesTable="CFAHMSTA" value="<%=szCdRsrcFaHomeStatus%>" tabIndex="<%=tabIndex++%>" />
      </td>
      <%-- SIR 18729 - Added onChange call to populateCounty function --%>
      <td>
        <impact:validateSelect name="selSzCdRsrcRegion" label="Region" conditionallyRequired="true" codesTable="CREGIONS" value="<%=szCdRsrcRegion%>" excludeOptions="<%= exOptions %>" onChange="populateCounty(false)" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selSzCdRsrcCnty" label="County" required="false" codesTable="CCOUNT" value="<%=szCdRsrcCnty%>" style="width: 150px" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateSelect name="selSzCdRsrcCategory" label="Category" conditionallyRequired="true" codesTable="CFACATEG" value="<%=szCdRsrcCategory%>" onChange="setHomeTypeDisable();" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" label="City" constraint="City" required="false" name="txtSzAddrRsrcAddrCity" cssClass="formInput" value="<%=szAddrRsrcAddrCity%>" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:validateSelect name="selCCdRsrcFaHomeType1" label="Home Type" required="false" codesTable="CFAHMTYP" value="<%=cCdRsrcFaHomeType1%>" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selSzCdRsrcLanguage" label="Language" codesTable="CLANG" value="<%=szCdRsrcLanguage%>" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateSelect name="selSzCdSchoolDistrict" label="School District" required="false" codesTable="CSCHDSTR" value="<%=szCdSchoolDistrict%>" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selSzCdMaritalStatus" label="Marital Status" excludeOptions="<%= excludeFAMSTRC %>" codesTable="CFAMSTRC" value="<%= szCdMaritalStatus %>" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateDate name="dtDtInquiryDate" label="Inquiry Date" size="10" constraint="Date" value="" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
  <%--  <tr>
       <td colspan="4">
        Registered With Adoption Exchange
        <impact:validateInput type="radio" name="rbIndRegAdptnExchge" label="Yes" value="Y" cssClass="formInput" onChange="setRegAdptExchng('Y');" checked="<%= checkRegAdptnExchgneYes %>" tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" name="rbIndRegAdptnExchge" label="No" value="no" cssClass="formInput" onChange="setRegAdptExchng('N');" checked="<%= checkRegAdptnExchgneNo %>" tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="hidden" name="hdnIndRegAdptnExchge" />
      </td>
    </tr>
   --%>
  </table>

  <br>
  <impact:ExpandableSectionTag name="AdvanceFAHomeSearch" id="lbAdvanceFAHomeSearch_Id" label="Advanced Search" tabIndex="<%= tabIndex++ %>">
     
         <table width="100%" cellspacing="0" cellpadding="3" class="tableBorder" border="0">

      <tr>
        <th colspan="6">
          Child Search
        </th>
      </tr>
      <tr class="subDetail">
       <td colspan= class="subDetail">
       <impact:validateInput type="text" label="Child Person Id"  constraint="Digit10Less" required="false" name="txtNbrChildPersonId" cssClass="formInput" value="<%=nbrChildPersonId%>" tabIndex="<%= tabIndex++ %>" size="10" maxLength="10"  />
        </td>
       <td colspan="2" class="alignRight">
        <impact:ButtonTag name="btnChildLookUp" img="btnSearch" form="<%=formName%>" action="/fad/FAHomeSearch/childLookup" tabIndex="<%= tabIndex++ %>" />
      </td > 
      <td colspan="2">
        </td>
      </tr>
	 <% if(szChildName != null && szChildName != ""){  %>
      <tr class="subDetail">
	<td>

        <impact:validateDisplayOnlyField label="Child Name"  name="txtSzNmChildName" value="<%= FormattingHelper.formatString( szChildName ) %>" />
      </td>
	  <td>
        <impact:validateDisplayOnlyField label="Age"  name="txtSzNmChildAge" value="<%= FormattingHelper.formatString( nbrChildAge) %>" />
      </td>
	  <td>
        <impact:validateDisplayOnlyField label="DOB"  name="txtSzNmChildDob"  value="<%= FormattingHelper.formatString( dtChildDob ) %>" />
      </td>
      </tr>
	  <%} %>
    </table>
		
		<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
           <tr>
		   <th colspan="2" id="childCharacteristics">Child Characteristics</th>
		        <td align="right">
     <a tabIndex="<%= tabIndex++ %>" onClick="hrefDirtyBypass=true;" href="javascript:expandAllCategories()">Expand All</a>&nbsp;
     <a tabIndex="<%= tabIndex++ %>" onClick="hrefDirtyBypass=true;" href="javascript:collapseAllCategories()">Collapse All</a>&nbsp;
     </td>
		   </tr>
		   </table>
		  
		  
          <%
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
			
			
        %>
        		<impact:ExpandableSectionTag name="<%= catCode %>" isExpanded="<%= isExpanded %>" id="" label="<%= catDecode %>" anchor="<%= cbxName %>" tabIndex="<%=tabIndex++%>">
				<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
		<%  

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
%>

		 			<tr>
		 			
		    <td><a href="<%= onClickSelectAll %>" tabIndex="<%=tabIndex++%>" onClick="hrefDirtyBypass=true;"> Select All Child Characteristics</a>
		    </td>
		  </tr>
		  <tr>
		    <td>
		    <a  href="<%= onClickDeSelectAll %>" tabIndex="<%=tabIndex++%>" onClick="hrefDirtyBypass=true;">Deselect All Child Characteristics</a>
		    </td>
		  </tr>
		  <tr class="subDetail">
		  <td colspan="2" class="subDetail">
						<impact:codesCheckbox
							defaultCodes="<%= validDefault != null ? validDefault :  checkedValues %>"
							name="<%= cbxName %>" codesTableName="<%= catCode %>"
							orderBy="decode" columns="3" isHorizontal="true"
							tabIndex="<%= tabIndex++ %>" excludeCodes="<%=excludeCodesChildChar %>" />
					</td>         
           </tr>
          </table>
		</impact:ExpandableSectionTag>
		<%
		}
		%>
          

    <br>
    <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE5">
  		<tr>
        	<th colspan="4">Child Race</th>
  		</tr>
	  	<tr class="subDetail">
	  		 <td>
		      <impact:codesCheckbox
		      name="cbxRace"
		      defaultCodes="<%=szCdRace%>"
		      codesTableName="<%=CodesTables.CADRACE%>"
		      columns="2"
		      isHorizontal="true"
		      disabled="false"
		      />
		   	</td>
  		</tr>
	</table>
	
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE6">
  		<tr>
        	<th colspan="4">Child Ethnicity</th>
  		</tr>
  		<tr class="subDetail">
	  		 <td>
		      <impact:codesCheckbox
		      name="cbxEth"
		      defaultCodes="<%=szCdEthnicity%>"
		      codesTableName="<%=CodesTables.CINDETHN%>"
		      columns="3"
		      isHorizontal="true"
		      disabled="false"/>
		   	</td>
  		</tr>
	</table>
	<br>
    <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" border="0">
      <tr>
        <th colspan="4">
          Child Demographics
        </th>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateSelect name="selCCdPersonSex" label="Gender" codesTable="CSEX" excludeOptions="<%= excludeGender %>" value="<%=cCdPersonSex%>" tabIndex="<%=tabIndex++%>" />
        </td>
        <td></td>
        <td></td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateSelect name="selCdReligion" label="Religion" codesTable="CRELIGNS" value="<%=szCdReligion%>" tabIndex="<%=tabIndex++%>" />
        </td>
        <td>
          <impact:validateInput type="text" label="Capacity" constraint="Numeric" required="false" name="txtNbrRsrcFacilCapacity" cssClass="formInput" value="<%=nbrRsrcFacilCapacity%>" tabIndex="<%= tabIndex++ %>" size="5" />
        </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateInput type="text" label="Current Placements" constraint="Numeric" required="false" name="txtNbrRsrcFacilCurrPlcmnt" cssClass="formInput" value="<%=nbrRsrcFacilCurrPlcmnts%>" tabIndex="<%= tabIndex++ %>" size="5" />
        </td>
        <td>
          <impact:validateInput type="text" label="Open Slots" constraint="Numeric" required="false" name="txtNbrRsrcFacilOpenSlots" cssClass="formInput" value="<%=nbrRsrcFacilOpenSlots%>" tabIndex="<%= tabIndex++ %>" size="5" />
        </td>
      </tr>      
      <tr class="subDetail">
        <td>
          <impact:validateSelect tabIndex="<%= tabIndex++ %>" name="cbxMinYear" label="Min Year" options="<%=yearOptions%>" value="<%=sMinYear%>" blankValue="true" disabled="false" />
        </td>
        <td>
          <impact:validateSelect tabIndex="<%= tabIndex++ %>" name="cbxMinMonth" label="Min Month" options="<%=monthOptions%>" value="<%=sMinMonth%>" blankValue="true" disabled="false" />
        </td>
      </tr>
      <tr class="subDetail">
        <td>
          <impact:validateSelect tabIndex="<%= tabIndex++ %>" name="cbxMaxYear" label="Max Year" options="<%=yearOptions%>" value="<%=sMaxYear%>" blankValue="true" disabled="false" />
        </td>
        <td>
          <impact:validateSelect tabIndex="<%= tabIndex++ %>" name="cbxMaxMonth" label="Max Month" options="<%=monthOptions%>" value="<%=sMaxMonth%>" blankValue="true" disabled="false" />
        </td>
      </tr>
    </table>
  </impact:ExpandableSectionTag>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td class="alignRight">
        <impact:ButtonTag name="btnSearch" img="btnSearch" function="return onSearchClick('S')" form="<%=formName%>" action="/fad/FAHomeSearch/faHomeSearch" backSafe="false" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>

  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<br />
<%--
**********************************************
**** FORM (Home Result) STARTS HERE ****
**********************************************
--%>
<%--SIR 23114 took out parameter for defaultButton=true.  It was causing
the specific page paginition to use the Add button intead of paginating--%>
<impact:validateForm name="frmFAHomeResult" method="post" action="/fad/FAHomeSearch/faHomeSearch" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">
  <%--
************************
**** SEARCH RESULTS ****
************************
--%>
  <%PaginationResultBean pPaginationResultBean = (PaginationResultBean) request
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

          %>

  <impact:pagination submitUrl="/fad/FAHomeSearch/faHomeSearch">

    <div class="alignRight">
      <div class="formInstruct">
        Scroll for more information -->
      </div>
    </div>
    <div id="faHomSearchResults" style="height:200px; width:765px; overflow:auto" class="tableborderList">
      <table border="0" cellpadding="3" cellspacing="0" width="1000">
        <tr class="thList">
          <td class="thList">
            Resource Name
          </td>
          <td class="thList">
            Category
          </td>
          <td class="thList">
            Status
          </td>
          <td class="thList">
            Dispstn
          </td>
          <td class="thList">
            Report ID
          </td>
          <td class="thList">
            Non-DFCS
          </td>
          <%-- SIR 22492 --%>
          <td class="thList">
            City
          </td>
          <td class="thList">
            Worker Name
          </td>
          <td class="thList">
            Worker Phone
          </td>
          <td class="thList">
            Ext
          </td>
        </tr>
        <%
           FAHomeValueBean homeRow = null;
           int iLoopCounter = 0;
           //SIR 23114 - added .isEmpty()
           if (faHomeList == null || faHomeList.isEmpty()) {
         %>
        <tr class="tableBG">
          <td colspan="9" class="subDetail">
            <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
          </td>
        </tr>
        <%} else if (faHomeList != null) {
            for (iLoopCounter = 0; iLoopCounter < faHomeList.size(); iLoopCounter++) {
              homeRow = (FAHomeValueBean) faHomeList.get(iLoopCounter);

              %>
        <tr class="<%= FormattingHelper.getRowCss( iLoopCounter + 1 ) %>">
          <%-- SIR 19048 -- Added the onClick to the href --%>
          <td>
            <a href="javascript:submitFormToHomeDetail( '<%=iLoopCounter%>','M')"><%=homeRow.getResourceName()%> </a>
          </td>
          <td>
            <%=Lookup.simpleDecodeSafe(CodesTables.CFACATEG, homeRow.getResourceCategory())%>
          </td>
          <td>
            <%=Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, homeRow.getFaHomeStatus())%>
          </td>
          <td>
            <%=StringHelper.getNonNullString(homeRow.getCdDispstn())%>
          </td>
          <td>
            <a href="javascript:submitStage_ID('<%=homeRow.getUlIdStage()%>')" tabIndex="<%=tabIndex++%>"><%=FormattingHelper.formatInt(homeRow.getUlIdStage())%></a>
          </td>
          <td>
            <%=StringHelper.getNonNullString(homeRow.getIndRsrcNonPrs())%>
          </td>
          <td>
            <%=homeRow.getCity()%>
          </td>
          <td>
            <%=homeRow.getPeronFullName()%>
          </td>
          <td>
            <%=(homeRow.getPhoneNumber() != null) ? FormattingHelper
                                                                                  .formatPhone(homeRow.getPhoneNumber())
                                                               : ""%>
          </td>
          <td>
            <%=(homeRow.getPhoneExtensionNumber() != null) ? homeRow.getPhoneExtensionNumber() : ""%>
          </td>
        </tr>
        <%}
          }

          %>
      </table>
    </div>
  </impact:pagination>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  <%if (bAddButton) {

            %>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td class="alignRight">
        <impact:ButtonTag name="btnAdd" img="btnAdd" function="submitFormForNewHome('A')" form="frmFAHomeResult" action="/fad/FAHomeSearch/displayNewHomeInformation" backSafe="false" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>
  <%}
        }
      }

    %>
</impact:validateForm>

<%-- SIR 18729 - Added call to populateCounty so it will populate on page load --%>
<script type="text/javascript" language="JavaScript1.2">
  populateCounty(true);
</script>

